package ee.ignorance.transformiceapi.event.mouse;

import ee.ignorance.transformiceapi.Mouse;
import ee.ignorance.transformiceapi.event.Event;

public class MouseFinishEvent implements Event<MouseFinishListener> {

        private Mouse mouse;

        public MouseFinishEvent(Mouse mouse) {
                this.mouse = mouse;
        }

        public Mouse getMouse() {
                return mouse;
        }

        @Override
        public void notifyListener(MouseFinishListener listener) {
                listener.mouseFinished(mouse);
        }
}
