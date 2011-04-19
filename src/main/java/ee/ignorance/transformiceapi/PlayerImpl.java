package ee.ignorance.transformiceapi;

import java.util.List;

import ee.ignorance.transformiceapi.event.Event;
import ee.ignorance.transformiceapi.event.EventService;
import ee.ignorance.transformiceapi.protocol.client.RoomChatRequest;
import ee.ignorance.transformiceapi.protocol.client.PrivateChatRequest;
import ee.ignorance.transformiceapi.protocol.client.TribeChatRequest;
import ee.ignorance.transformiceapi.protocol.client.CommandRequest;
import ee.ignorance.transformiceapi.protocol.client.CrouchRequest;
import ee.ignorance.transformiceapi.protocol.client.DeathRequest;
import ee.ignorance.transformiceapi.protocol.client.HoleRequest;
import ee.ignorance.transformiceapi.protocol.client.LoginRequest;
import ee.ignorance.transformiceapi.protocol.client.MagicBeginRequest;
import ee.ignorance.transformiceapi.protocol.client.MagicCastRequest;
import ee.ignorance.transformiceapi.protocol.client.MagicStopRequest;
import ee.ignorance.transformiceapi.protocol.client.MovementDoneRequest;
import ee.ignorance.transformiceapi.protocol.client.PositionRequest;
import ee.ignorance.transformiceapi.protocol.client.TakeCheeseRequest;
import ee.ignorance.transformiceapi.protocol.client.TribeListRequest;

public class PlayerImpl implements Player {

        private static final long TIMEOUT = 10000;
        
        private GameConnection connection;

        private String username;
        private String password;
        private String gameCode;

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

        @Override
        public void login() throws GameException {
                try {
                        LoginRequest request = new LoginRequest(username, password);
                        connection.sendRequest(request);
                        loginResult = null;
                        synchronized (this) {
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

        @Override
        public void changeRoom(final String roomName) throws GameException {
                try {
                        command("room " + roomName);
                        synchronized (this) {
                                long startTime = System.currentTimeMillis();
                                while (!getRoom().equals(roomName)) {
                                        wait(500);
                                        if (System.currentTimeMillis() - startTime > TIMEOUT) {
                                                throw new GameException("Change room times out");
                                        }
                                }
                        }
                } catch (InterruptedException ignored) {
                } catch (GameException e) {
                        getConnection().terminate("Change room failed", e);
                }
        }

        @Override
        public void move(int posX, int posY, int movX, int movY,
                boolean goingLeft, boolean goingRight, boolean jumping) {
                move(posX, posY, movX, movY, goingLeft, goingRight, jumping, (byte) 0, (byte) 0);
        }

        @Override
        public void move(int posX, int posY, int movX, int movY, boolean goingLeft,
                boolean goingRight, boolean jumping, byte jumpingImage, byte unk) {
                setCurrentX(posX);
                setCurrentY(posY);
                PositionRequest request = new PositionRequest(getGameCode(),
                        posX, posY, movX, movY, goingLeft, goingRight, jumping, jumpingImage, unk);
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
                TribeChatRequest request = new TribeChatRequest(message);
                connection.sendRequest(request);
        }

        @Override
        public void privateChat(String recipient, String message) {
                PrivateChatRequest request = new PrivateChatRequest(recipient, message.replaceAll("<", "&lt;"));
                connection.sendRequest(request);
        }

        @Override
        public void cry() {
                command("cry");
        }

        @Override
        public void dance() {
                command("dance");
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
        public void kiss() {
                command("kiss");
        }

        @Override
        public void laugh() {
                command("laugh");
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

        @Override
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
                for (Mouse mouse : roomMice) {
                        if (mouse.getCode() == id) {
                                return mouse;
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
        public void crouch() {
                getConnection().sendRequest(new CrouchRequest(true));
        }

        @Override
        public void standUp() {
                getConnection().sendRequest(new CrouchRequest(false));
        }

        @Override
        public void tribeList() {
                getConnection().sendRequest(new TribeListRequest());
        }

        @Override
        public void profile(String nickname) {
                command("profile " + nickname);        
        }
}
