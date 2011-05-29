package ee.ignorance.transformiceapi;

import ee.ignorance.transformiceapi.event.Event;
import java.util.List;

/**
 * All external code should use this interface.
 * Provide only necessary methods
 * @author Alex
 */
public interface Player {

        /* chat methods */
        void privateChat(String recipient, String message);

        void roomChat(String message);

        void tribeChat(String message);

        /* event service methods */
        <L> void addListener(Class<? extends Event<L>> eventClass, L listener);

        <L> void removeListener(Class<? extends Event<L>> eventClass, L listener);

        /* emote methods */
        void cry();

        void dance();

        void kiss();

        void laugh();

        /* movement methods */
        void crouch();

        void goLeft();

        void goRight();

        void jump();

        void move(int posX, int posY, int movX, int movY,
                boolean goingLeft, boolean goingRight, boolean jumping);

        void move(int posX, int posY, int movX, int movY,
                boolean goingLeft, boolean goingRight, boolean jumping, byte jumpingImage, byte unk);

        void movementDone();  //use to avoid server afk kill at 1:30

        void moveTo(int x, int y);

        void standUp();

        /* mouse methods */
        void cheese();

        void die();

        void hole();

        /* shaman related methods */
        void magic(MagicType type, int x, int y);

        void magic(MagicType type, int x, int y, int rotation, int dx, int dy, boolean solid);

        void createObject(MagicType type, int x, int y);

        void createObject(MagicType type, int x, int y, int rotation, int dx, int dy, boolean solid);

        /*  Spawns a balloon at specified coordinates and attaches a mouse to it. */
        void balloon(Mouse mouse, int x, int y);
        
        /* other unrelated */
        void changeRoom(String roomName);
        
        void command(String string); //send command string to the server

        void friend(String nickname);
        
        Mouse getPlayerMouse();

        String getRoom();
        
        List<Mouse> getRoomMice();

        void login() throws GameException;

        void profile(String nickname);

        void tribeList();

        void friendList();
}
