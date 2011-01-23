package ee.ignorance.transformiceapi.event;


public abstract class MouseMovedListener  implements EventListener {

	@Override
	public boolean matches(Event e) {
		return e instanceof MouseMovedEvent;
	}
}
