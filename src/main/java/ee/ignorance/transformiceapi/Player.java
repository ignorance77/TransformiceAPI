package ee.ignorance.transformiceapi;

import ee.ignorance.transformiceapi.event.EventListener;

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
	
}
