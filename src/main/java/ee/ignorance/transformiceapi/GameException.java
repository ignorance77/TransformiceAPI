package ee.ignorance.transformiceapi;

public class GameException extends Exception {

	public GameException(String message, Throwable e) {
		super(message, e);
	}

	public GameException(String message) {
		super(message);
	}

}
