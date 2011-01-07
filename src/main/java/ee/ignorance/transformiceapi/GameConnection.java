package ee.ignorance.transformiceapi;

import org.apache.log4j.Logger;

import ee.ignorance.transformiceapi.protocol.client.AbstractClientRequest;
import ee.ignorance.transformiceapi.protocol.server.AbstractCommand;

public class GameConnection {

	private static final Logger logger = Logger.getLogger( GameConnection.class );
	
	private String host;
	private int port;
	private String version;
	
	private Player player;
		
	public GameConnection(String host, int port, String version) {
		this.host = host;
		this.port = port;
		this.version = version;
	}
		
	public void connect() {
		startListening();
	}
	
	private void startListening() {
		ServerListener listener = new ServerListener( this );
		listener.run();
	}

	public Player createPlayer(String username, String password) throws GameException {
		if (player != null) {
			throw new GameException("Player was already created for this connection");
		}
		Thread.currentThread().setName("P-" + username);
		player = new Player( this );
		return player;
	}

	public void sendRequest(AbstractClientRequest request) {
		
	}
	
	public void processCommand(AbstractCommand command) {
		CommandProcessor processor = CommandProcessor.create(command);
		processor.process(command, player);
	}
	
}
