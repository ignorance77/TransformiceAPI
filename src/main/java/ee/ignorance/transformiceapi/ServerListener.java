package ee.ignorance.transformiceapi;

public class ServerListener implements Runnable {

	private GameConnection connection;
	
	public ServerListener(GameConnection connection) {
		this.connection = connection;
	}
	
	@Override
	public void run() {
		
	}

}
