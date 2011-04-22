package ee.ignorance.transformiceapi.event.mouse;

import ee.ignorance.transformiceapi.Mouse;
import ee.ignorance.transformiceapi.event.Event;

public class MouseCrouchEvent implements Event<MouseCrouchListener> {

        private Mouse mouse;

        public MouseCrouchEvent(Mouse mouse) {
                this.mouse = mouse;
        }

        public Mouse getMouse() {
                return mouse;
        }

        @Override
        public void notifyListener(MouseCrouchListener listener) {
                listener.mouseCrouched(mouse);
        }
}
