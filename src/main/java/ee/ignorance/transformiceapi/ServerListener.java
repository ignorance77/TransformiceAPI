package ee.ignorance.transformiceapi;

import java.io.DataInputStream;
import java.io.IOException;

import org.apache.log4j.Logger;

import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.protocol.server.Processable;


public class ServerListener implements Runnable {

	private static final Logger logger = Logger.getLogger(ServerListener.class);
	
	private final GameConnection connection;
	private final DataInputStream in;
	
	private volatile boolean terminate;
	
	public ServerListener(GameConnection connection) {
		this.connection = connection;
		in = connection.getInputStream();
	}
	
	@Override
	public void run() {
		try {
			while (!terminate) {
				byte[] message = readMessage();
				parse(message);
			}
		} catch (IOException e) {
			logger.warn("connection terminated", e);
			connection.shutdown();
		}
	}

	public void terminate() {
		this.terminate = true;
	}

	private byte[] readMessage() throws IOException {
		int len = in.readInt() - 4;
		byte[] buff = new byte[len];
		in.readFully(buff);
		return buff;
	}

	private void parse(byte[] message) {
		try {
			Processable response = ServerMessagesParser.parse(message);
			if (response != null) {
				AbstractProcessor processor = response.getProcessor();
				processor.process(response, connection);
			}
		} catch (IOException e) {
			logger.warn("Failed to parse server response", e);
		}
	}

}
