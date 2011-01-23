package ee.ignorance.transformiceapi.event;


public abstract class MouseGotCheeseListener implements EventListener {

	@Override
	public boolean matches(Event e) {
		return e instanceof MouseGotCheeseEvent;
	}
}
