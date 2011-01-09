package ee.ignorance.transformiceapi;

import java.util.List;

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
	private String gameCode;
	
	private int currentX;
	private int currentY;
	
	private String room;
	private List<Mouse> roomMice;
	
	private int mouseId;
	private boolean admin;
	private boolean moderator;
	private Mouse playerMouse;
	
	private Boolean loginResult;
	private boolean syncStatus;
	
	public Player(String username, String password, GameConnection connection) {
		this.connection = connection;
		this.username = username;
		this.password = password;
	}

	public boolean login(boolean waitToFinish) {
		loginResult = null;
		LoginRequest request = new LoginRequest( username, password );
		connection.sendRequest(request);
		if (waitToFinish) {
			new Blocker(20) {
				@Override
				public boolean check() {
					return loginResult != null;
				}
			};
		}
		return loginResult;
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

	public void setRoomMice(List<Mouse> mice) {
		for (Mouse mouse : mice) {
			if (mouse.getCode() == mouseId) {
				setPlayerMouse(mouse);
			}
		}
		this.roomMice = mice;
	}

	public int getMouseId() {
		return mouseId;
	}

	public void setMouseId(int mouseId) {
		this.mouseId = mouseId;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public boolean isModerator() {
		return moderator;
	}

	public void setModerator(boolean moderator) {
		this.moderator = moderator;
	}

	public Boolean getLoginResult() {
		return loginResult;
	}

	public void setLoginResult(Boolean loginResult) {
		this.loginResult = loginResult;
	}

	public Mouse getPlayerMouse() {
		return playerMouse;
	}

	public void setPlayerMouse(Mouse playerMouse) {
		this.playerMouse = playerMouse;
	}

	public boolean isSyncStatus() {
		return syncStatus;
	}

	public void setSyncStatus(boolean syncStatus) {
		this.syncStatus = syncStatus;
	}
	
	
}
