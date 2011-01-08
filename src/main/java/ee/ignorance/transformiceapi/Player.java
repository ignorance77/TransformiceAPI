package ee.ignorance.transformiceapi;

import ee.ignorance.transformiceapi.protocol.client.ChatRequest;
import ee.ignorance.transformiceapi.protocol.client.CommandRequest;
import ee.ignorance.transformiceapi.protocol.client.HoleRequest;
import ee.ignorance.transformiceapi.protocol.client.LoginRequest;
import ee.ignorance.transformiceapi.protocol.client.PositionRequest;
import ee.ignorance.transformiceapi.protocol.client.TakeCheeseRequest;

public class Player {

	private GameConnection connection;
	private String username;
	private String password;
	private String room;
	private String gameCode;
	
	private int currentX;
	private int currentY;
	
	public Player(String username, String password, GameConnection connection) {
		this.connection = connection;
		this.username = username;
		this.password = password;
	}

	public void login(boolean waitToFinish) {
		LoginRequest request = new LoginRequest( username, password );
		connection.sendRequest(request);
		if (waitToFinish) {
			new Blocker(20) {
				@Override
				public boolean check() {
					return getGameCode() != null;
				}
			};
		}
	}
	
	public void changeRoom(final String roomName, boolean waitToFinish) {
		CommandRequest request = new CommandRequest("room " + roomName);
		connection.sendRequest(request);
		if (waitToFinish) {
			new Blocker(20) {
				@Override
				public boolean check() {
					return getRoom().equals(roomName);
				}
			};
		}
	}
	
	public void move(int x, int y) {
		currentX = x;
		currentY = y;
		PositionRequest request = new PositionRequest(getGameCode(), x, y);
		connection.sendRequest(request);
	}
	
	public void chat(String message) {
		ChatRequest request = new ChatRequest(message);
		connection.sendRequest(request);
	}
	
	public void command(String message) {
		CommandRequest request = new CommandRequest(message);
		connection.sendRequest(request);
	}

	public void setRoom(String room) {
		this.room = room;
	}
	
	public String getRoom() {
		return room;
	}

	public String getGameCode() {
		return gameCode;
	}

	public void setGameCode(String gameCode) {
		this.gameCode = gameCode;
	}

	public void cheese() {
		TakeCheeseRequest request = new TakeCheeseRequest(getGameCode());
		connection.sendRequest(request);
	}

	public void hole() {
		HoleRequest request = new HoleRequest(getGameCode());
		connection.sendRequest(request);
	}

	public GameConnection getConnection() {
		return connection;
	}
	
	
	
}
