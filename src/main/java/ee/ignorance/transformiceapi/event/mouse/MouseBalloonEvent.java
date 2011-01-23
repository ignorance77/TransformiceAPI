package ee.ignorance.transformiceapi.event.mouse;

import ee.ignorance.transformiceapi.Mouse;
import ee.ignorance.transformiceapi.event.Event;


public class MouseBalloonEvent implements Event {

        private Mouse mouse;

        public MouseBalloonEvent(Mouse mouse) {
                setMouse(mouse);
        }

        public Mouse getMouse() {
                return mouse;
        }

        public void setMouse(Mouse mouse) {
                this.mouse = mouse;
        }
}
