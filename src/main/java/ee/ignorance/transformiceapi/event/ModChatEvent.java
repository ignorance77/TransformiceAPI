package ee.ignorance.transformiceapi.event;

public class ModChatEvent implements Event {

	private String message;

	public ModChatEvent(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
