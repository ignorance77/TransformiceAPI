package ee.ignorance.transformiceapi;

import java.io.BufferedReader;
import java.io.IOException;

import org.apache.log4j.Logger;

import ee.ignorance.transformiceapi.protocol.ByteBuffer;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;

public class ServerListener implements Runnable {

	private static final Logger logger = Logger.getLogger(ServerListener.class);
	
	private GameConnection connection;
	
	private BufferedReader in;
	
	public ServerListener(GameConnection connection) {
		this.connection = connection;
	}
	
	@Override
	public void run() {
		try {
			in = connection.getInputStream();
			while (true) {
				while (in.ready()) {
					byte[] bytes = readMessage();
					AbstractResponse response = ServerMessagesParser.parse(bytes);
					if (response != null) {
						connection.processCommand(response);
					}
				}
				Thread.sleep(50);
			}
		} catch (Exception e) {
                    e.printStackTrace();
			logger.error("Error receiving data ", e);
		}
	}

	private byte[] readMessage() throws IOException {
		ByteBuffer bf = new ByteBuffer();
		int cur;
		while ((cur = in.read()) != 0 && (cur != -1)) {
			bf.write(cur);
		}
		return bf.getBytes();
	}

}
