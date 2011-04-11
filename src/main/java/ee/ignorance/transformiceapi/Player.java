package ee.ignorance.transformiceapi;

import ee.ignorance.transformiceapi.event.Event;

/**
 * All external code should use this interface.
 * Provide only necessary methods
 * @author Alex
 */
public interface Player {

	void cheese();

	void dance();

	void hole();

	Mouse getPlayerMouse();

	void login() throws GameException;

	void changeRoom(String roomName) throws GameException;

	<L> void addListener(Class<? extends Event<L>> eventClass, L listener);

        <L> void removeListener(Class<? extends Event<L>> eventClass, L listener);

	void goLeft();
	
	void goRight();
	
	void jump();
	
	void die();

        void move(int posX, int posY, int movX, int movY,
                boolean goingLeft, boolean goingRight, boolean jumping);

         void move(int posX, int posY, int movX, int movY,
                boolean goingLeft, boolean goingRight, boolean jumping, byte jumpingImage, byte unk);

	void moveTo(int x, int y);

	void roomChat(String message);

	void privateChat(String recipient, String message);

	void tribeChat(String message);

	void cry();

	void smile();

	void magic(int type, int x, int y);

	void kiss();
	
	void createObject(int type, int x, int y);

	void command(String string);

        public void movementDone();

        void crouch();

        void standUp();

        void requestTribeList();

        void requestProfile(String nickname);
	
}
