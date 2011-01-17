package ee.ignorance.transformiceapi;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.util.Arrays;

import org.apache.log4j.Logger;

import ee.ignorance.transformiceapi.processors.CommandProcessor;
import ee.ignorance.transformiceapi.protocol.client.AbstractClientRequest;
import ee.ignorance.transformiceapi.protocol.client.RegisterRequest;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.IntroduceResponse;
import ee.ignorance.transformiceapi.protocol.server.LoginFailedResponse;
import ee.ignorance.transformiceapi.protocol.server.LoginSuccessResponse;
import ee.ignorance.transformiceapi.protocol.server.URLResponse;

public class GameConnection {

	private static final Logger logger = Logger.getLogger( GameConnection.class );
	
	private long MAXWAITTIME = 10000;

	private String host;
	private int port;
	private String version;
	
	private PlayerImpl player;
	private Socket socket;	
	
	private DataInputStream in;
	private DataOutputStream out;
	
	private boolean urlSent = false;

	private int[] MDT;
	private Integer CMDTEC = 2;

	private Boolean registerResult;
	
	private ServerListener serverListener;
	private PingThread pingThread;

	
	public GameConnection(String host, int port, String version) {
		this.host = host;
		this.port = port;
		this.version = version;
	}
		
	public void connect(boolean login, Proxy proxy) throws GameException {
		try {
			if (proxy != null) {
				socket = new Socket(proxy);
			} else {
				socket = new Socket();
			}
			socket.connect(new InetSocketAddress(host, port), 1500);
			in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
//			out = new BufferedWriter()(socket.getOutputStream(), true);
			out = new DataOutputStream(socket.getOutputStream());
			startListening();
			introduce();
			long startTime = System.currentTimeMillis();
			while (!(urlSent)) {
				synchronized (this) {
					wait(509);
					if (System.currentTimeMillis() - startTime > MAXWAITTIME ) {
						throw new GameException("Connect timed out");
					}
				}
			}
			if (login) {
				startPingThread();
			}
		} catch (Exception e) {
			terminate("Connect failed", e);
		}
	}
	
	public void terminate(String message, Throwable e) throws GameException {
		serverListener.terminate();
		if (pingThread != null) {
			pingThread.terminate();
		}
		throw new GameException(message, e);
	}

	private void startPingThread() {
		pingThread = new PingThread( this );
		pingThread.start();
	}

	private void sendURL() {
		try {
			String url = "http://br2.transformice.com/Transformice.swf?n=0.129 xx"; 
			out.writeInt(url.getBytes().length + 4 + 8);
			int val = 1001;
			out.writeByte(val % 1000);
			out.writeByte((val/100) % 10);
			out.writeByte((val/10)%10);	
			out.writeByte(val%10);
			out.writeByte(1);
			out.writeByte(1);
			out.writeUTF("http://br2.transformice.com/Transformice.swf?n=0.132 xx"); // it seems it doesnt matter what we send..?
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void introduce() throws IOException {
		int size = (version.getBytes().length + 4);
		int val = 1000;
		out.writeInt(size + 8);
		out.writeByte(val % 1000);
		out.writeByte((val/100) % 10);
		out.writeByte((val/10)%10);	
		out.writeByte(val%10);
		out.writeByte(1);
		out.writeByte(1);
		out.writeUTF(version);
		out.flush();
	}

	private void startListening() {
		serverListener = new ServerListener( this );
		new Thread(serverListener).start();
	}

	public Player createPlayer(String username, String password) throws GameException {
		if (player != null) {
			throw new GameException("Player was already created for this connection");
		}
		Thread.currentThread().setName("P-" + username);
		player = new PlayerImpl( username, password, this );
		return player;
	}

	public void sendRequest(AbstractClientRequest request) {
		try {
			out.writeInt(request.getBytes().length + 8 + 4);
			writePrefix();
			out.writeByte(1);
			out.writeByte(1);
			out.writeShort(request.getBytes().length);
			out.writeBytes(new String(request.getBytes()));
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
        
	private void writePrefix() throws IOException {
		int val = (CMDTEC % 9000) + 1000;
		out.writeByte(MDT[val / 1000]);
		out.writeByte(MDT[(val/100) % 10]);
		out.writeByte(MDT[(val/10)%10]);	
		out.writeByte(MDT[val%10]);
		CMDTEC++;
	}

	public void processCommand(AbstractResponse command) {
		if (command instanceof IntroduceResponse) {
			sendURL();
		} else {
			if (command instanceof URLResponse) {
				urlSent = true;
				MDT = ((URLResponse) command).getMDT();
				CMDTEC = ((URLResponse) command).getCMDTEC();
			} else {
				CommandProcessor processor = CommandProcessor.create(command);
				if (player == null) {
					// registering
					if (command instanceof LoginSuccessResponse) {
						registerResult = true;
					} else if (command instanceof LoginFailedResponse) {
						registerResult = false;
					}
				} else {
					if (processor != null) {
						processor.process(command, player);
					}
				}
			}
		}
	}

	public DataInputStream getInputStream() {
		return in;
	}
	
	public void registerPlayer(String username, String password) throws GameException {
		RegisterRequest registerRequest = new RegisterRequest(username, password);
		sendRequest(registerRequest);
		try {
			synchronized ( this ) {
				registerResult = null;
				long startTime = System.currentTimeMillis();
				while (registerResult == null) {
					wait(500);
					if (System.currentTimeMillis() - startTime > MAXWAITTIME) {
						throw new GameException("Register timed out");
					}
				}
			}
		} catch (Exception e) {
			terminate("Register failed : ", e);
		}
	}

	public void disconnect() {
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
