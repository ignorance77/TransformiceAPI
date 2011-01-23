package ee.ignorance.transformiceapi.event.mouse;

import ee.ignorance.transformiceapi.Mouse;
import ee.ignorance.transformiceapi.event.Event;

public class MouseDeathEvent implements Event {

        private Mouse mouse;

        public MouseDeathEvent(Mouse mouse) {
                setMouse(mouse);
        }

        public Mouse getMouse() {
                return mouse;
        }

        public void setMouse(Mouse mouse) {
                this.mouse = mouse;
        }

}
