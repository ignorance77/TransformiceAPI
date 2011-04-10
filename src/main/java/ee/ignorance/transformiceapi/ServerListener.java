package ee.ignorance.transformiceapi;

import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.log4j.Logger;


public class ServerListener implements Runnable {

	private static final Logger logger = Logger.getLogger(ServerListener.class);
	
	private GameConnection connection;
	
	private DataInputStream in;

	private boolean terminate;
	
	public ServerListener(GameConnection connection) {
		this.connection = connection;
	}
	
	@Override
	public void run() {
		try {
			in = connection.getInputStream();
			while (true) {
					while (in.available() > 0) {
						byte[] message = readMessage();
						AbstractResponse response = ServerMessagesParser.parse(message);
						if (response != null) {
							synchronized (connection) {
								connection.processCommand(response);
								connection.notifyAll();
							}
						}
					}
					Thread.sleep(50);
					if (terminate) {
						break;
					}
			}
		} catch (Exception e) {
                    e.printStackTrace();
			logger.error("Error receiving data ", e);
		}
	}

	private byte[] readMessage() throws IOException {
		int len = in.readInt();
		ByteArrayOutputStream ret = new ByteArrayOutputStream();
		for (int i = 0; i < len - 4; i++) {
			byte c = in.readByte();
			ret.write(c);
		}
		return ret.toByteArray();
	}

	public void terminate() {
		this.terminate = true;
	}
	
	

}
