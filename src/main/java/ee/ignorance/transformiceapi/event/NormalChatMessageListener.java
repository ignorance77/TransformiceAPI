package ee.ignorance.transformiceapi.event;

public abstract class NormalChatMessageListener implements EventListener {

	@Override
	public boolean matches(Event e) {
		return e instanceof NormalChatMessageEvent;
	}


}
