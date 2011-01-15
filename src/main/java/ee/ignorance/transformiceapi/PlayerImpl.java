package ee.ignorance.transformiceapi;

import java.util.List;

import ee.ignorance.transformiceapi.event.Event;
import ee.ignorance.transformiceapi.event.EventListener;
import ee.ignorance.transformiceapi.event.EventService;
import ee.ignorance.transformiceapi.protocol.client.ChatRequest;
import ee.ignorance.transformiceapi.protocol.client.CommandRequest;
import ee.ignorance.transformiceapi.protocol.client.CryRequest;
import ee.ignorance.transformiceapi.protocol.client.DanceRequest;
import ee.ignorance.transformiceapi.protocol.client.DeathRequest;
import ee.ignorance.transformiceapi.protocol.client.HoleRequest;
import ee.ignorance.transformiceapi.protocol.client.KissRequest;
import ee.ignorance.transformiceapi.protocol.client.LoginRequest;
import ee.ignorance.transformiceapi.protocol.client.MagicBeginRequest;
import ee.ignorance.transformiceapi.protocol.client.MagicCastRequest;
import ee.ignorance.transformiceapi.protocol.client.MagicStopRequest;
import ee.ignorance.transformiceapi.protocol.client.PositionRequest;
import ee.ignorance.transformiceapi.protocol.client.SmileRequest;
import ee.ignorance.transformiceapi.protocol.client.TakeCheeseRequest;

public class PlayerImpl implements Player {

	private static final long TIMEOUT = 10000;
	
	private GameConnection connection;
	private String username;
	private String password;
	private String gameCode;
	
	private int currentX;
	private int currentY;
	
	private String room = "null";
	private List<Mouse> roomMice;
	
	private int mouseId;
	private boolean admin;
	private boolean moderator;
	private Mouse playerMouse;
	
	private Boolean loginResult;
	private boolean syncStatus;
	
	private Integer secondShamanCode;
	private boolean isShaman;

    private EventService eventService;
    
	public PlayerImpl(String username, String password, GameConnection connection) {
		this.connection = connection;
		this.username = username;
		this.password = password;
        this.eventService = new EventService();
	}

	public void login() throws GameException {
		try {
			LoginRequest request = new LoginRequest( username, password );
			connection.sendRequest(request);
			loginResult = null;
			synchronized ( this ) {
				long startTime = System.currentTimeMillis();
				while (loginResult == null) {
					wait(500);
					if (System.currentTimeMillis() - startTime > TIMEOUT) {
						throw new GameException("Login timed out");
					}
				}
			}
			if (!loginResult) {
				throw new GameException("Login failed");
			}
		} catch (Exception e) {
			getConnection().terminate("Player login failed: ", e);
		}
	}
	
	public void changeRoom(final String roomName) throws GameException {
		try {
			CommandRequest request = new CommandRequest("room " + roomName);
			connection.sendRequest(request);
			synchronized(this) {
				long startTime = System.currentTimeMillis();
				while (!getRoom().equals(roomName)) {
					wait(500);
					if (System.currentTimeMillis() - startTime > TIMEOUT) {
						throw new GameException("Change room times out");
					}
				}
			}
		} catch (InterruptedException e) {
			getConnection().terminate("Change room failed", e);
		}
	}
	
	@Override
	public void move(int x, int y) {
		currentX = x;
		currentY = y;
		PositionRequest request = new PositionRequest(getGameCode(), x, y);
		connection.sendRequest(request);
	}
	
	@Override
	public void normalChat(String message) {
		ChatRequest request = new ChatRequest(message);
		connection.sendRequest(request);
	}

	@Override
    public void tribeChat(String message) {
            command("t "+message);
	}

	@Override
	public void privateChat(String recipient, String message) {
		command("c " + recipient + " " + message);
	}

	@Override
	public void cry() {
		CryRequest request = new CryRequest(getGameCode());
		connection.sendRequest(request);
	}

    @Override
	public void dance() {
		DanceRequest request = new DanceRequest(getGameCode());
		connection.sendRequest(request);
	}

	@Override
	public void die() {
		DeathRequest request = new DeathRequest(getGameCode());
		connection.sendRequest(request);
	}

	@Override
	public void kiss() {
		KissRequest request = new KissRequest(getGameCode());
		connection.sendRequest(request);
	}

	@Override
	public void smile() {
		SmileRequest request = new SmileRequest(getGameCode());
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

	@Override
	public void cheese() {
		TakeCheeseRequest request = new TakeCheeseRequest(getGameCode());
		connection.sendRequest(request);
	}

	@Override
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

	public Integer getSecondShamanCode() {
		return secondShamanCode;
	}

	public void setSecondShamanCode(Integer secondShamanCode) {
		this.secondShamanCode = secondShamanCode;
	}

	public boolean isShaman() {
		return isShaman;
	}

	public void setShaman(boolean isShaman) {
		this.isShaman = isShaman;
	}
	
	@Override
	public void magic(int type, int x, int y) {
		MagicBeginRequest magicBeginRequest = new MagicBeginRequest(type, x, y);
		getConnection().sendRequest(magicBeginRequest);
		sleep(50);
		MagicCastRequest magicCastRequest = new MagicCastRequest(type, x, y);
		getConnection().sendRequest(magicCastRequest);
		sleep(50);
		MagicStopRequest magicStopRequest = new MagicStopRequest();
		getConnection().sendRequest(magicStopRequest);
	}
	
	private void sleep(long interval) {
		try {
			Thread.sleep(interval);
		} catch (InterruptedException e) {
		}
	}

	@Override
	public void registerEventListener(EventListener listener) {
		eventService.registerEventListener(listener);
	}
	
	public void notifyListeners(Event e) {
		eventService.notifyListeners(e);
	}
	
	@Override
	public void goLeft() {
		PositionRequest request = new PositionRequest(getGameCode(), currentX, currentY, false, true);
		getConnection().sendRequest(request);
	}
	
	@Override
	public void goRight() {
		PositionRequest request = new PositionRequest(getGameCode(), currentX, currentY, true, false);
		getConnection().sendRequest(request);
	}
	
	@Override
	public void jump() {
		PositionRequest request = new PositionRequest(getGameCode(), currentX, currentY, false, false, true);
		getConnection().sendRequest(request);
	}

	public Mouse getMouseByID(int id) {
		for (Mouse mouse : roomMice) {
			if (mouse.getCode() == id) {
				return mouse;
			}
		}
		return null;
	}

	public List<Mouse> getRoomMice() {
		return roomMice;
	}
}
