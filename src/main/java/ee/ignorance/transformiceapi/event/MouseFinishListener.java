package ee.ignorance.transformiceapi.event;

public abstract class MouseFinishListener implements EventListener {

	@Override
	public boolean matches(Event e) {
		return e instanceof MouseFinishEvent;
	}

}
