package ee.ignorance.transformiceapi.event.mouse;

import ee.ignorance.transformiceapi.Mouse;
import ee.ignorance.transformiceapi.event.Event;

public class MouseMoveEvent implements Event<MouseMoveListener> {

        private Mouse mouse;

        public MouseMoveEvent(Mouse mouse) {
                this.mouse = mouse;
        }

        public Mouse getMouse() {
                return mouse;
        }

        @Override
        public void notifyListener(MouseMoveListener listener) {
                listener.mouseMoved(mouse);
        }
}
