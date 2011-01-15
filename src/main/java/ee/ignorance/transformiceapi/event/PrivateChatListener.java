package ee.ignorance.transformiceapi.event;

public abstract class PrivateChatListener implements EventListener {

	@Override
	public boolean matches(Event e) {
		return e instanceof PrivateChatEvent;
	}


}
