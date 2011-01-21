package ee.ignorance.transformiceapi;

import ee.ignorance.transformiceapi.event.EventListener;

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

	void registerEventListener(EventListener listener);

	void goLeft();
	
	void goRight();
	
	void jump();
	
	void die();

        void move(int posX, int posY, int movX, int movY,
                boolean goingLeft, boolean goingRight, boolean jumping);

	void moveTo(int x, int y);

	void normalChat(String message);

	void privateChat(String recipient, String message);

	void tribeChat(String message);

	void cry();

	void smile();

	void magic(int type, int x, int y);

	void kiss();
	
	void createObject(int type, int x, int y);

	void command(String string);
	
}
