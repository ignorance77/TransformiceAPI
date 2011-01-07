package ee.ignorance.transformiceapi;

import ee.ignorance.transformiceapi.protocol.client.LoginRequest;

public class Player {

	private GameConnection connection;

	public Player(GameConnection connection) {
		this.connection = connection;
	}

	public void login() {
		LoginRequest request = new LoginRequest();
		connection.sendRequest(request);
	}
	
	public void changeRoom(String roomName) {
		// TODO
	}
	
	public void move(int x, int y) {
		// TODO
	}
	
	public void chat(String message) {
		// TODO
	}
	
	public void command(String message) {
		// TODO
	}
	
}
