package ee.ignorance.transformiceapi.event;

public abstract class TribeChatMessageListener implements EventListener {

	@Override
	public boolean matches(Event e) {
		return e instanceof TribeChatMessageEvent;
	}

}
