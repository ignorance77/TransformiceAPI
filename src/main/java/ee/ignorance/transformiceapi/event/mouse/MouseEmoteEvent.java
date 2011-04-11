package ee.ignorance.transformiceapi.event.mouse;

import ee.ignorance.transformiceapi.Mouse;
import ee.ignorance.transformiceapi.event.Event;

public class MouseEmoteEvent implements Event<MouseEmoteListener> {

        private Mouse mouse;

        public MouseEmoteEvent(Mouse mouse) {
                this.mouse = mouse;
        }

        public Mouse getMouse() {
                return mouse;
        }

        @Override
        public void notifyListener(MouseEmoteListener listener) {
                listener.mouseEmoted(mouse);
        }
}
