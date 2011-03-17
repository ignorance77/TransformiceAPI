package ee.ignorance.transformiceapi.event.mouse;

import ee.ignorance.transformiceapi.Mouse;
import ee.ignorance.transformiceapi.event.Event;

public class MouseLeaveRoomEvent implements Event {

        private Mouse mouse;

        public MouseLeaveRoomEvent(Mouse mouse) {
                this.mouse = mouse;
        }

        public Mouse getMouse() {
                return mouse;
        }

        public void setMouse(Mouse mouse) {
                this.mouse = mouse;
        }
}
