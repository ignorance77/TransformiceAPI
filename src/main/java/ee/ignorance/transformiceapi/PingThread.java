package ee.ignorance.transformiceapi;

import ee.ignorance.transformiceapi.protocol.client.PingRequest;

public class PingThread extends Thread {

	private GameConnection connection;
	
	private long lastPingTime;
	
	public PingThread(GameConnection connection) {
		this.connection = connection;
		this.lastPingTime = System.currentTimeMillis();
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(11000);
			} catch (InterruptedException e) {
			}
			sendPing();
		}
	}
	
	private void sendPing() {
		PingRequest pingRequest = new PingRequest( lastPingTime );
		connection.sendRequest(pingRequest);
	}
	
}
