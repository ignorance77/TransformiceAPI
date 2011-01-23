package ee.ignorance.transformiceapi.event.mouse;

import ee.ignorance.transformiceapi.event.Event;
import ee.ignorance.transformiceapi.event.EventListener;

public abstract class MouseFinishListener implements EventListener {

	@Override
	public boolean matches(Event e) {
		return e instanceof MouseFinishEvent;
	}

}
