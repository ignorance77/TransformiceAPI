package ee.ignorance.transformiceapi.event.mouse;

import ee.ignorance.transformiceapi.Mouse;
import ee.ignorance.transformiceapi.event.Event;

public class MouseFinishEvent implements Event {

	private Mouse mouse;
	
	public MouseFinishEvent(Mouse mouse) {
		super();
		this.mouse = mouse;
	}
	
	public Mouse getMouse() {
		return mouse;
	}
	
	public void setMouse(Mouse mouse) {
		this.mouse = mouse;
	}
}
