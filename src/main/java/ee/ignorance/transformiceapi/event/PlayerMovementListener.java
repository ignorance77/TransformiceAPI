package ee.ignorance.transformiceapi.event;


public abstract class PlayerMovementListener  implements EventListener {

	@Override
	public boolean matches(Event e) {
		return e instanceof PlayerMovementEvent;
	}
}
