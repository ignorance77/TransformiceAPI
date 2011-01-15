package ee.ignorance.transformiceapi;

public class GameException extends Exception {

	private static final long serialVersionUID = -5083427202521076519L;

	public GameException(String message, Throwable e) {
		super(message, e);
	}

	public GameException(String message) {
		super(message);
	}

}
