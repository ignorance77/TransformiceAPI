package ee.ignorance.transformiceapi.event;

public abstract class PlayerProfileListener implements EventListener {

	@Override
	public boolean matches(Event e) {
		return e instanceof PlayerProfileEvent;
	}


}
