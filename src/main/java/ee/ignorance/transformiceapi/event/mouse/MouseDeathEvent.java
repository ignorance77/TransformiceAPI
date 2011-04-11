package ee.ignorance.transformiceapi.event.mouse;

import ee.ignorance.transformiceapi.Mouse;
import ee.ignorance.transformiceapi.event.Event;

public class MouseDeathEvent implements Event<MouseDeathListener> {

        private Mouse mouse;

        public MouseDeathEvent(Mouse mouse) {
                this.mouse = mouse;
        }

        public Mouse getMouse() {
                return mouse;
        }

        @Override
        public void notifyListener(MouseDeathListener listener) {
                listener.mouseDied(mouse);
        }
}
