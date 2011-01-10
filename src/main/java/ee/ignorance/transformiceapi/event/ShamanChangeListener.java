package ee.ignorance.transformiceapi.event;

public abstract class ShamanChangeListener implements EventListener {

	@Override
	public boolean matches(Event e) {
		return e instanceof ShamanChangeEvent;
	}

}
