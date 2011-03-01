package ee.ignorance.transformiceapi.event;

public abstract class TribeListListener implements EventListener {

	@Override
	public boolean matches(Event e) {
		return e instanceof TribeListEvent;
	}


}
