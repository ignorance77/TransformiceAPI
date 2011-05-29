package ee.ignorance.transformiceapi;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.protocol.client.AbstractClientRequest;
import ee.ignorance.transformiceapi.protocol.client.DeathRequest;
import ee.ignorance.transformiceapi.protocol.client.MagicCastRequest;
import ee.ignorance.transformiceapi.protocol.client.PositionRequest;
import ee.ignorance.transformiceapi.protocol.client.PrivateChatRequest;
import ee.ignorance.transformiceapi.protocol.client.RegisterRequest;
import ee.ignorance.transformiceapi.protocol.client.RoomChatRequest;
import ee.ignorance.transformiceapi.protocol.client.TribeChatRequest;

public class GameConnection {

        private static final Logger logger = Logger.getLogger(GameConnection.class);
        private static final long MAXWAITTIME = 10000;

        private String host;
        private int port;
        private int version;
        private PlayerImpl player;

        private Socket socket;
        private DataInputStream in;
        private DataOutputStream out;

        private int[] MDT;
        private int CMDTEC;
        
        private boolean registerResult;
        private CountDownLatch introduceLatch = new CountDownLatch(1);
        private CountDownLatch registerLatch = new CountDownLatch(1);
        
        private ServerListener serverListener;
        private PingThread pingThread;

        public GameConnection(String host, int port, int version) {
                this.host = host;
                this.port = port;
                this.version = version;
        }

        public void connect(boolean login, Proxy proxy) throws GameException {
        	setProxy(proxy);
	
			try {
				socket.setKeepAlive(true);
				socket.connect(new InetSocketAddress(host, port), 1500);
				in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
				out = new DataOutputStream(socket.getOutputStream());
				logger.debug("Successfully connected");
			} catch (IOException e) {
				shutdown();
				throw new GameException("Connect failed", e);
			}
			startListening();
			introduce();
	
			boolean success = waitForIntroduceResponse();
			if (!success) {
				shutdown();
				throw new GameException("Introduce failed. Wrong version number?");
			}
			if (login) {
				startPingThread();
			}	
			logger.debug("Successfully introduced");
        }

        public Player createPlayer(String username, String password) throws GameException {
                if (player != null) {
                        throw new GameException("Player was already created for this connection");
                }
                Thread.currentThread().setName("P-" + username);
                player = new PlayerImpl(username, password, this);
                return player;
        }

        public void disconnect() throws IOException {
             if (socket != null) {
                     socket.close();
             }       
        }

        public DataInputStream getInputStream() {
                return in;
        }

        public PlayerImpl getPlayer() {
                return player;
        }

        public boolean registerPlayer(String username, String password) throws GameException {
			RegisterRequest registerRequest = new RegisterRequest(username, password);
			sendRequest(registerRequest);
	
			boolean success = waitForRegisterResponse();
			if (!success) {
				shutdown();
				throw new GameException("Register timed out");
			}
			
			return registerResult;
        }

        public synchronized void sendRequest(AbstractClientRequest request) {
                try {
                        if (request instanceof PositionRequest) {
                                out.writeInt(request.getBytes().length + 8);
                                writePrefix();
                                out.write(request.getBytes());
                                out.flush();
                        } else if (request instanceof RoomChatRequest) {
                                out.writeInt(request.getBytes().length + 8);
                                writePrefix();
                                out.write(request.getBytes());
                                out.flush();
                        } else if (request instanceof TribeChatRequest) {
                                out.writeInt(request.getBytes().length + 8);
                                writePrefix();
                                out.write(request.getBytes());
                                out.flush();
                        } else if (request instanceof PrivateChatRequest) {
                                out.writeInt(request.getBytes().length + 8);
                                writePrefix();
                                out.write(request.getBytes());
                                out.flush();
                        } else if (request instanceof MagicCastRequest) {
                                out.writeInt(request.getBytes().length + 8);
                                writePrefix();
                                out.write(request.getBytes());
                                out.flush();
                        } else if (request instanceof DeathRequest) {
                                out.writeInt(request.getBytes().length + 8);
                                writePrefix();
                                out.write(request.getBytes());
                                out.flush();  
                        } else {
                                out.writeInt(request.getBytes().length + 8 + 4);
                                writePrefix();
                                out.writeByte(1);
                                out.writeByte(1);
                                out.writeShort(request.getBytes().length);
                                out.write(request.getBytes());
                                out.flush();
                        }
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }

        public void setPrefix(int[] MDT, int CMDTEC) {
                this.MDT = MDT;
                this.CMDTEC = CMDTEC;
        }

        public void setRegisterResult(boolean registerResult) {
                this.registerResult = registerResult;
                registerLatch.countDown();
        }

        public void setIntroduceSuccessful() {
                introduceLatch.countDown();	
        }
        
        public void terminate(String message, Throwable e) throws GameException {
                if (serverListener != null) {
                        serverListener.terminate();
                }
                closeQuietly();
                if (pingThread != null) {
                        pingThread.terminate();
                }
                throw new GameException(message, e);
        }

        public void shutdown() {
			if (serverListener != null) {
				serverListener.terminate();
			}
			if (pingThread != null) {
				pingThread.terminate();
			}
			closeQuietly();
        }
        
        private void closeQuietly() {
                if (socket == null) {
                        return;
                }

                try {
                        socket.close();
                } catch (IOException ignored) {
                }
        }

        private void introduce()  {
                try {
					out.writeInt(12);
		              out.writeInt(0);
		                out.writeByte(28);
		                out.writeByte(1);
		                out.writeShort(version);
		                out.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
  
        }
        
        private void setProxy(Proxy proxy) {
			if (proxy != null) {
				socket = new Socket(proxy);
			} else {
				socket = new Socket();
			}
        }
        
        private void startPingThread() {
                pingThread = new PingThread(this);
                pingThread.start();
        }

        private void startListening() {
                serverListener = new ServerListener(this);
                new Thread(serverListener).start();
        }

        private boolean waitForIntroduceResponse() {
    		try {
    			return introduceLatch.await(MAXWAITTIME, TimeUnit.MILLISECONDS);
    		} catch (InterruptedException e) {
    			throw new RuntimeException("Unexpectedly interrupted");
    		}
        }
        
        private boolean waitForRegisterResponse() {
    		try {
    			return registerLatch.await(MAXWAITTIME, TimeUnit.MILLISECONDS);
    		} catch (InterruptedException e) {
    			throw new RuntimeException("Unexpectedly interrupted");
    		}
        }
        
        private void writePrefix() throws IOException {
                int val = (CMDTEC % 9000) + 1000;
                out.writeByte(MDT[val / 1000]);
                out.writeByte(MDT[(val / 100) % 10]);
                out.writeByte(MDT[(val / 10) % 10]);
                out.writeByte(MDT[val % 10]);
                CMDTEC++;
        }
}
