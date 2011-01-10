package ee.ignorance.transformiceapi.event;

public abstract class ShamanStatusListener implements EventListener {

	@Override
	public boolean matches(Event e) {
		return e instanceof ShamanStatusEvent;
	}

}
