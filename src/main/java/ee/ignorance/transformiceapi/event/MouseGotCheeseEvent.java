package ee.ignorance.transformiceapi.event;

import ee.ignorance.transformiceapi.Mouse;


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
