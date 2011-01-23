package ee.ignorance.transformiceapi.event.mouse;

import ee.ignorance.transformiceapi.Mouse;
import ee.ignorance.transformiceapi.event.Event;


public class MouseEmoteEvent implements Event {

        private Mouse mouse;
        private int emote;

        public MouseEmoteEvent(Mouse mouse) {
                setMouse(mouse);
        }

        public Mouse getMouse() {
                return mouse;
        }

        public void setMouse(Mouse mouse) {
                this.mouse = mouse;
        }

}
