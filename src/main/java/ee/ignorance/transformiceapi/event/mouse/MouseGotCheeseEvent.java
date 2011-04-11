package ee.ignorance.transformiceapi.event.mouse;

import ee.ignorance.transformiceapi.Mouse;
import ee.ignorance.transformiceapi.event.Event;

public class MouseGotCheeseEvent implements Event<MouseGotCheeseListener> {

        private Mouse mouse;

        public MouseGotCheeseEvent(Mouse mouse) {
                this.mouse = mouse;
        }

        public Mouse getMouse() {
                return mouse;
        }

        @Override
        public void notifyListener(MouseGotCheeseListener listener) {
                listener.mouseGotCheese(mouse);
        }
}
