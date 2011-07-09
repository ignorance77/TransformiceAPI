package ee.ignorance.transformiceapi;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import ee.ignorance.transformiceapi.event.Event;
import ee.ignorance.transformiceapi.event.EventService;
import ee.ignorance.transformiceapi.protocol.client.BalloonDetachRequest;
import ee.ignorance.transformiceapi.protocol.client.MouseBalloonRequest;
import ee.ignorance.transformiceapi.protocol.client.MouseEmoteRequest;
import ee.ignorance.transformiceapi.protocol.client.MoveCheeseRequest;
import ee.ignorance.transformiceapi.protocol.client.RoomChatRequest;
import ee.ignorance.transformiceapi.protocol.client.PrivateChatRequest;
import ee.ignorance.transformiceapi.protocol.client.ShopInfoRequest;
import ee.ignorance.transformiceapi.protocol.client.TribeChangeRankRequest;
import ee.ignorance.transformiceapi.protocol.client.TribeChatRequest;
import ee.ignorance.transformiceapi.protocol.client.CommandRequest;
import ee.ignorance.transformiceapi.protocol.client.CrouchRequest;
import ee.ignorance.transformiceapi.protocol.client.DeathRequest;
import ee.ignorance.transformiceapi.protocol.client.DefriendRequest;
import ee.ignorance.transformiceapi.protocol.client.HoleRequest;
import ee.ignorance.transformiceapi.protocol.client.LoginRequest;
import ee.ignorance.transformiceapi.protocol.client.MagicBeginRequest;
import ee.ignorance.transformiceapi.protocol.client.MagicCastRequest;
import ee.ignorance.transformiceapi.protocol.client.MagicStopRequest;
import ee.ignorance.transformiceapi.protocol.client.MovementDoneRequest;
import ee.ignorance.transformiceapi.protocol.client.PositionRequest;
import ee.ignorance.transformiceapi.protocol.client.TakeCheeseRequest;
import ee.ignorance.transformiceapi.protocol.client.TribeAcceptInviteRequest;
import ee.ignorance.transformiceapi.protocol.client.TribeListRequest;
import ee.ignorance.transformiceapi.protocol.client.TribeKickRequest;
import ee.ignorance.transformiceapi.protocol.client.FriendListRequest;
import ee.ignorance.transformiceapi.shop.Item;
import ee.ignorance.transformiceapi.shop.Outfit;
import ee.ignorance.transformiceapi.titles.TribeRank;

public class PlayerImpl implements Player {

        private static final long TIMEOUT = 10000;
        private static final Logger logger = Logger.getLogger(Player.class);
        
        private GameConnection connection;

        private String username;
        private String password;
        private String gameCode;

        private String room = "null";
        private List<Mouse> roomMice;
        
        private int cheeseInShop;
        private Outfit currentOutfit = Outfit.NAKED;
        private List<Item> ownedItems;

        private int mouseId;
        private boolean admin;
        private boolean moderator;
        private Mouse playerMouse;

        private CountDownLatch loginLatch = new CountDownLatch(1);
        private boolean loginResult;
        private boolean sync;

        private boolean shaman;
        
        private EventService eventService;

        public PlayerImpl(String username, String password, GameConnection connection) {
                this.connection = connection;
                this.username = username;
                this.password = password;
                this.eventService = new EventService();
        }
        
        @Override
        public void login() throws GameException {
			login("1"); // 1 - auto room
        }
        
        @Override
        public void login(String room) throws GameException {
	
			LoginRequest request = new LoginRequest(username, password, room);
			connection.sendRequest(request);
	
			boolean success = waitForLoginResponse();
			if (!success) {
				connection.shutdown();
				throw new GameException("Login timed out");
			}
			if (!loginResult) {
				connection.shutdown();
				throw new GameException("Wrong password");
			}
			logger.debug("Successfully logged in");
        }

        @Override
        public void changeRoom(final String roomName) {
			command("room " + roomName);  
        }

        @Override
        public void move(int posX, int posY, int movX, int movY,
                boolean goingLeft, boolean goingRight, boolean jumping) {
                move(posX, posY, movX, movY, goingLeft, goingRight, jumping, (byte) 0, (byte) 0);
        }

        @Override
        public void move(int posX, int posY, int movX, int movY, boolean goingLeft,
                boolean goingRight, boolean jumping, byte jumpingImage, byte portalId) {
                setCurrentX(posX);
                setCurrentY(posY);
                PositionRequest request = new PositionRequest(getGameCode(),
                        posX, posY, movX, movY, goingLeft, goingRight, jumping, jumpingImage, portalId);
                connection.sendRequest(request);
        }

        @Override
        public void moveTo(int x, int y) {
                move(x, y, 0, 0, false, false, false);
        }

        @Override
        public void roomChat(String message) {
                RoomChatRequest request = new RoomChatRequest(message.replaceAll("<", "&lt;"));
                connection.sendRequest(request);
        }

        public void setCurrentX(int currentX) {
                getPlayerMouse().setPosX(currentX);
        }

        public void setCurrentY(int currentY) {
                getPlayerMouse().setPosY(currentY);
        }

        public int getCurrentX() {
                return getPlayerMouse().getPosX();
        }

        public int getCurrentY() {
                return getPlayerMouse().getPosY();
        }

        @Override
        public void tribeChat(String message) {
                TribeChatRequest request = new TribeChatRequest(message.replaceAll("<", "&lt;"));
                connection.sendRequest(request);
        }

        @Override
        public void privateChat(String recipient, String message) {
                PrivateChatRequest request = new PrivateChatRequest(recipient, message.replaceAll("<", "&lt;"));
                connection.sendRequest(request);
        }

        @Override
        public void emote(Mouse.Emote emote) {
                connection.sendRequest(new MouseEmoteRequest(emote));
        }

        @Override
        public void cry() {
                emote(Mouse.Emote.Cry);
        }

        @Override
        public void dance() {
                emote(Mouse.Emote.Dance);
        }

        @Override
        public void die() {
                DeathRequest request = new DeathRequest(gameCode);
                connection.sendRequest(request);
        }

        @Override
        public void friend(String nickname) {
                command("friend " + nickname);
        }
		
        @Override
        public void defriend(String nickname) {
                DefriendRequest request = new DefriendRequest(nickname);
                connection.sendRequest(request);
        }

        @Override
        public void kiss() {
                emote(Mouse.Emote.Kiss);
        }

        @Override
        public void laugh() {
                emote(Mouse.Emote.Smile);
        }

        @Override
        public void command(String message) {
                message = message.replaceAll("<", "&lt;"); //otherwise the Server will filter it out
                CommandRequest request = new CommandRequest(message);
                connection.sendRequest(request);
        }

        public void setRoom(String room) {
                this.room = room;
        }

        @Override
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
        
        public int getCheeseInShop() {
        	return cheeseInShop;
        }
        
        public void setCheeseInShop(int cheeseInShop) {
        	this.cheeseInShop = cheeseInShop;
        }
        
        public Outfit getCurrentOutfit() {
        	return currentOutfit;
        }
        public void setCurrentOutfit(Outfit outfit) {
        	currentOutfit = outfit;
        }
        
        public List<Item> getOwnedItems() {
        	return ownedItems;
        }
        
        public void setOwnedItems(List<Item> ownedItems) {
        	this.ownedItems = ownedItems;
        }
        
        public int getMouseId() {
                return mouseId;
        }

        public void setMouseId(int mouseId) {
                this.mouseId = mouseId;
        }

        @Override
        public boolean isAdmin() {
                return admin;
        }

        public void setAdmin(boolean admin) {
                this.admin = admin;
        }

        @Override
        public boolean isModerator() {
                return moderator;
        }

        public void setModerator(boolean moderator) {
                this.moderator = moderator;
        }

        public Boolean getLoginResult() {
                return loginResult;
        }

        public void setLoginResult(boolean loginResult) {
                this.loginResult = loginResult;
                loginLatch.countDown();
        }

        @Override
        public Mouse getPlayerMouse() {
                return playerMouse;
        }

        public void setPlayerMouse(Mouse playerMouse) {
                this.playerMouse = playerMouse;
        }

        @Override
        public boolean isSync() {
                return sync;
        }

        public void setSync(boolean sync) {
                this.sync = sync;
        }

        @Override
        public boolean isShaman() {
                return shaman;
        }

        public void setShaman(boolean shaman) {
                this.shaman = shaman;
        }

        @Override
        public void magic(MagicType type, int x, int y) {
                magic(type, x, y, 0, 0, 0, true);
        }

        @Override
        public void magic(MagicType type, int x, int y, int rotation, int dx, int dy, boolean solid) {
                MagicBeginRequest magicBeginRequest = new MagicBeginRequest(type, x, y, rotation);
                getConnection().sendRequest(magicBeginRequest);
                sleep(50);
                MagicCastRequest magicCastRequest = new MagicCastRequest(type, x, y, rotation, dx, dy, solid);
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
        public <L> void addListener(Class<? extends Event<L>> eventClass, L listener) {
                eventService.add(eventClass, listener);
        }

        @Override
        public <L> void removeListener(Class<? extends Event<L>> eventClass, L listener) {
                eventService.remove(eventClass, listener);
        }

        @Override
        public void removeListeners(Class<? extends Event<?>> eventClass) {
        	eventService.remove(eventClass);
        }
        
        @Override
        public void removeAllListeners() {
        	eventService.removeAll();
        }
        
        public <L> void notifyListeners(Event<L> e) {
                eventService.notify(e);
        }

        @Override
        public void goLeft() {
                move(getCurrentX(), getCurrentY(), 0, 0, false, true, false);
        }

        @Override
        public void goRight() {
                move(getCurrentX(), getCurrentY(), 0, 0, true, false, false);
        }

        @Override
        public void jump() {
                move(getCurrentX(), getCurrentY(), 0, 0, false, false, true);
        }

        public Mouse getMouseById(int id) {
                if (roomMice != null) {
                        for (Mouse mouse : roomMice) {
                                if (mouse.getCode() == id) {
                                        return mouse;
                                }
                        }
                }
                return null;
        }

        public Mouse getMouseByName(String name) {
                for (Mouse mouse : roomMice) {
                        if (mouse.getName().equals(name)) {
                                return mouse;
                        }
                }
                return null;
        }

        @Override
        public List<Mouse> getRoomMice() {
                return roomMice;
        }

        @Override
        public void createObject(MagicType type, int x, int y) {
                createObject(type, x, y, 0, 0, 0, true);
        }

        @Override
        public void createObject(MagicType type, int x, int y, int rotation, int dx, int dy, boolean solid) {
                MagicCastRequest magicCastRequest = new MagicCastRequest(type, x, y, rotation, dx, dy, solid);
                getConnection().sendRequest(magicCastRequest);
        }

        @Override
        public void movementDone() {
                getConnection().sendRequest(new MovementDoneRequest());
        }

        @Override
        public void balloon(Mouse mouse, int x, int y) {
        	connection.sendRequest(new MagicCastRequest(MagicType.Balloon, x, y));
        	connection.sendRequest(new MouseBalloonRequest(mouse));
        
        }
        
        @Override
        public void crouch() {
                getConnection().sendRequest(new CrouchRequest(true));
        }

        @Override
        public void standUp() {
                getConnection().sendRequest(new CrouchRequest(false));
        }

        @Override
        public void detachBalloon() {
                getConnection().sendRequest(new BalloonDetachRequest());
        }

        @Override
        public void tribeList() {
                getConnection().sendRequest(new TribeListRequest());
        }

        @Override
        public void changeTribeRank(String playerName, TribeRank rank) {
            	getConnection().sendRequest(new TribeChangeRankRequest(playerName, rank));
        }

        @Override
        public void recruitToTribe(String playerName) {
                command("rt " + playerName);
        }

        @Override
        public void kickFromTribe(String playerName) {
                getConnection().sendRequest(new TribeKickRequest(playerName));
        }

        @Override
        public void acceptTribeInvite(int tribeId) {
                getConnection().sendRequest(new TribeAcceptInviteRequest(tribeId));
        }

        @Override
        public void moveCheese(int x, int y) {
        	connection.sendRequest(new MoveCheeseRequest(x, y));
        }
        
        @Override
        public void profile(String nickname) {
                command("profile " + nickname);        
        }

        @Override
        public void friendList() {
                getConnection().sendRequest(new FriendListRequest());
        }
        
        @Override
        public void shopInfo() {
        		getConnection().sendRequest(new ShopInfoRequest());
        }
        
        @Override
        public void shutdown() {
        	connection.shutdown();
        }
        
        private boolean waitForLoginResponse() {
        	try {
    			return loginLatch.await(TIMEOUT, TimeUnit.MILLISECONDS);
    		} catch (InterruptedException e) {
    			throw new RuntimeException("Unexpectedly interrupted");
    		}
        }
}
