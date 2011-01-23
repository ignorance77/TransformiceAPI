package ee.ignorance.transformiceapi.event;

import ee.ignorance.transformiceapi.Mouse;

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
