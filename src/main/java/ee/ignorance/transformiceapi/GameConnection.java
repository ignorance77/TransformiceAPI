package ee.ignorance.transformiceapi;

import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;

import org.apache.log4j.Logger;

import ee.ignorance.transformiceapi.protocol.client.AbstractClientRequest;
import ee.ignorance.transformiceapi.protocol.client.ChatNormalRequest;
import ee.ignorance.transformiceapi.protocol.client.ChatPrivateRequest;
import ee.ignorance.transformiceapi.protocol.client.ChatTribeRequest;
import ee.ignorance.transformiceapi.protocol.client.MagicCastRequest;
import ee.ignorance.transformiceapi.protocol.client.PositionRequest;
import ee.ignorance.transformiceapi.protocol.client.RegisterRequest;

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

        private boolean urlSent = false;
        private int[] MDT;
        private Integer CMDTEC = 2;
        private Boolean registerResult;
        
        private ServerListener serverListener;
        private PingThread pingThread;

        public GameConnection(String host, int port, int version) {
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

                        socket.setKeepAlive(true);
                        socket.connect(new InetSocketAddress(host, port), 1500);
                        in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                        out = new DataOutputStream(socket.getOutputStream());

                        startListening();
                        introduce();
                        long startTime = System.currentTimeMillis();
                        while (!(urlSent)) {
                                synchronized (this) {
                                        wait(509);
                                        if (System.currentTimeMillis() - startTime > MAXWAITTIME) {
                                                throw new GameException("Wrong version number?");
                                        }
                                }
                        }
                        if (login) {
                                startPingThread();
                        }
      
                } catch (InterruptedException ignored) {
                } catch (GameException e) {
                        terminate("Introduce failed", e);
                } catch (IOException e) {
                        terminate("Connect failed", e);
                }
        }

        public PlayerImpl createPlayer(String username, String password) throws GameException {
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

        public void processCommand(AbstractResponse command) {
                AbstractProcessor processor = command.getProcessor();
                processor.process(command, this);
        }

        public void registerPlayer(String username, String password) throws GameException {
                RegisterRequest registerRequest = new RegisterRequest(username, password);
                sendRequest(registerRequest);
                try {
                        synchronized (this) {
                                registerResult = null;
                                long startTime = System.currentTimeMillis();
                                while (registerResult == null) {
                                        wait(500);
                                        if (System.currentTimeMillis() - startTime > MAXWAITTIME) {
                                                throw new GameException("Register timed out");
                                        }
                                }
                        }
                } catch (InterruptedException ignored) {
                } catch (GameException e) {
                        terminate("Register failed", e);
                }
        }

        public synchronized void sendRequest(AbstractClientRequest request) {
                try {
                        if (request instanceof PositionRequest) {
                                out.writeInt(request.getBytes().length + 8);
                                writePrefix();
                                out.writeBytes(new String(request.getBytes()));
                                out.flush();
                        } else if (request instanceof ChatNormalRequest) {
                                out.writeInt(request.getBytes().length + 8);
                                writePrefix();
                                out.writeBytes(new String(request.getBytes()));
                                out.flush();
                        } else if (request instanceof ChatTribeRequest) {
                                out.writeInt(request.getBytes().length + 8);
                                writePrefix();
                                out.writeBytes(new String(request.getBytes()));
                                out.flush();
                        } else if (request instanceof ChatPrivateRequest) {
                                out.writeInt(request.getBytes().length + 8);
                                writePrefix();
                                out.writeBytes(new String(request.getBytes()));
                                out.flush();
                        } else if (request instanceof MagicCastRequest) {
                                out.writeInt(request.getBytes().length + 8);
                                writePrefix();
                                out.writeBytes(new String(request.getBytes()));
                                out.flush();
                        } else {
                                out.writeInt(request.getBytes().length + 8 + 4);
                                writePrefix();
                                out.writeByte(1);
                                out.writeByte(1);
                                out.writeShort(request.getBytes().length);
                                out.writeBytes(new String(request.getBytes()));
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
        }

        public void setUrlSent(boolean urlSent) {
                this.urlSent = urlSent;
        }
        
        public void terminate(String message, Throwable e) throws GameException {
                serverListener.terminate();
                closeQuietly();
                if (pingThread != null) {
                        pingThread.terminate();
                }
                throw new GameException(message, e);
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

        private void introduce() throws IOException {
                out.writeInt(12);
                out.writeInt(0);
                out.writeByte(28);
                out.writeByte(1);
                out.writeShort(version);
                out.flush();
        }

        private void startPingThread() {
                pingThread = new PingThread(this);
                pingThread.start();
        }

        private void startListening() {
                serverListener = new ServerListener(this);
                new Thread(serverListener).start();
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
