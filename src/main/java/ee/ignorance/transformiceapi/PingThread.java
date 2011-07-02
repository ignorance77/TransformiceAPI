package ee.ignorance.transformiceapi;

import ee.ignorance.transformiceapi.protocol.client.PingRequest;

public class PingThread extends Thread {

	private static final long PING_INTERVAL = 11000;
	private static final long SLEEP_TIME = 250;
	
	private final GameConnection connection;

	private long lastPingTime;

	private volatile boolean terminate;

	public PingThread(GameConnection connection) {
		this.connection = connection;
		this.lastPingTime = System.currentTimeMillis();
	}

	@Override
	public void run() {
		try {
			while (!terminate) {
				sleep(SLEEP_TIME);
				if (System.currentTimeMillis() - lastPingTime >= PING_INTERVAL) {
					long tmp = System.currentTimeMillis();
					sendPing();
					lastPingTime = tmp;
				}

			}
		} catch (InterruptedException e) {
			throw new RuntimeException("Ping thread failed", e);
		}
	}

	private void sendPing() {
		PingRequest pingRequest = new PingRequest(lastPingTime);
		connection.sendRequest(pingRequest);
	}

	public void terminate() {
		this.terminate = true;
	}

}
