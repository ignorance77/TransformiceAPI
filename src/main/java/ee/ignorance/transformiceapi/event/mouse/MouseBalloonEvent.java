package ee.ignorance.transformiceapi.event.mouse;

import ee.ignorance.transformiceapi.Mouse;
import ee.ignorance.transformiceapi.event.Event;

public class MouseBalloonEvent implements Event<MouseBalloonListener> {

        private Mouse mouse;

        public MouseBalloonEvent(Mouse mouse) {
                this.mouse = mouse;
        }

        public Mouse getMouse() {
                return mouse;
        }

        @Override
        public void notifyListener(MouseBalloonListener listener) {
                listener.mouseBallooned(mouse);
        }
}
