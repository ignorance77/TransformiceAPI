package ee.ignorance.transformiceapi.event;

public class ModChatMessageEvent implements Event {

        private String sender;
	private String message;

	public ModChatMessageEvent(String sender, String message) {
		super();
		this.message = message;
                this.sender = sender;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

        public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}
	
	
}
