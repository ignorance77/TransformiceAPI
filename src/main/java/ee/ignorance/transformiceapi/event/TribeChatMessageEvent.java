package ee.ignorance.transformiceapi.event;

public class TribeChatMessageEvent implements Event {

	private String sender;
	private String message;
	
	public TribeChatMessageEvent(String sender, String message) {
		this.sender = sender;
		this.message = message;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
