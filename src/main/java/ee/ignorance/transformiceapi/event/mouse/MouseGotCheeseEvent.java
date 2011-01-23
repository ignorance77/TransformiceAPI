package ee.ignorance.transformiceapi.event.mouse;

import ee.ignorance.transformiceapi.Mouse;
import ee.ignorance.transformiceapi.event.Event;


public class MouseGotCheeseEvent implements Event {

	private Mouse mouse;
	
	public MouseGotCheeseEvent(Mouse mouse) {
		setMouse(mouse);
	}

        public void setMouse(Mouse mouse){
                this.mouse = mouse;
        }

        public Mouse getMouse(){
                return mouse;
        }
}
