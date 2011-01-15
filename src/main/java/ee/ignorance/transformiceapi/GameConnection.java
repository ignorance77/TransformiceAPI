package ee.ignorance.transformiceapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;

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
	
	private Player player;
	private Socket socket;	
	
	private BufferedReader in;
	private PrintWriter out;
	
	private boolean introduced = false;
	private boolean urlSent = false;

	private char[] MDT;
	private Integer CMDTEC;

	private Boolean registerResult;
	private Boolean connected;
	
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
			connected = false;
			socket.connect(new InetSocketAddress(host, port), 1500);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);
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
			connected = true;
			if (login) {
				startPingThread();
			}
		} catch (Exception e) {
			terminate("Connect failed", e);
		}
	}
	
	private void terminate(String message, Throwable e) throws GameException {
		serverListener.terminate();
		if (pingThread != null) {
			pingThread.terminate();
		}
		throw new RuntimeException(message, e);
	}

	private void startPingThread() {
		pingThread = new PingThread( this );
		pingThread.start();
	}

	private void sendURL() {
		out.print("http://br2.transformice.com/Transformice.swf?n=0.129 xx"); // it seems it doesnt matter what we send..?
		out.write(0x00);
		out.flush();
	}
	
	private void introduce() {
		out.print(version);
		out.write(0x00);
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
		player = new Player( username, password, this );
		return player;
	}

	public void sendRequest(AbstractClientRequest request) {
		writePrefix();
		out.write(request.getBytes());
		out.write(0x00);
		out.flush();
	}
        
	private void writePrefix() {
		String local2 = Integer.toString((CMDTEC % 9000) + 1000);
		int d1 = local2.charAt(0) - '0';
		int d2 = local2.charAt(1) - '0';
		int d3 = local2.charAt(2) - '0';
		int d4 = local2.charAt(3) - '0';
		String begin = "" + MDT[d1] + "" + MDT[d2] + "" + MDT[d3] + "" +  MDT[d4];
		CMDTEC++;
		out.print(begin);
	}

	public void processCommand(AbstractResponse command) {
		if (command instanceof IntroduceResponse) {
			introduced = true;
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

	public BufferedReader getInputStream() {
		return in;
	}
	
	public boolean registerPlayer(String username, String password) {
		registerResult = null;
		RegisterRequest registerRequest = new RegisterRequest(username, password);
		sendRequest(registerRequest);
		new Blocker(20) {
			@Override
			public boolean check() {
				return registerResult != null;
			}
		};
		return registerResult;
	}

	public void disconnect() {
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean isConnected() {
		return connected;
	}
	
}
