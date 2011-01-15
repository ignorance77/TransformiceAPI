package ee.ignorance.transformiceapi;

import ee.ignorance.transformiceapi.protocol.client.PingRequest;

public class PingThread extends Thread {

	private static final long PING_INTERVAL = 11000;

	private GameConnection connection;
	
	private long lastPingTime;
	
	private boolean terminate;
	
	public PingThread(GameConnection connection) {
		this.connection = connection;
		this.lastPingTime = System.currentTimeMillis();
	}

	@Override
	public void run() {
		try {
			synchronized (this) {
				while (!terminate) {
					wait(500);
					if (System.currentTimeMillis() - lastPingTime >= PING_INTERVAL) {
						lastPingTime = System.currentTimeMillis();
						sendPing();
					}
				}
			}
		} catch (InterruptedException e) {
			throw new RuntimeException("Ping thread failed", e);
		}
	}
	
	private void sendPing() {
		PingRequest pingRequest = new PingRequest( lastPingTime );
		connection.sendRequest(pingRequest);
	}

	public void terminate() {
		this.terminate = true;
	}
	
}
