package ee.ignorance.transformiceapi.event.mouse;

import ee.ignorance.transformiceapi.Mouse;
import ee.ignorance.transformiceapi.event.Event;


public class MouseEmoteEvent implements Event<MouseEmoteListener> {

        private Mouse mouse;
        private int emote;

        public MouseEmoteEvent(Mouse mouse, int emote) {
                this.mouse = mouse;
                this.emote = emote;
        }

        public Mouse getMouse() {
                return mouse;
        }

        public int getEmote() {
                return emote;
        }

        @Override
        public void notifyListener(MouseEmoteListener listener) {
                listener.mouseEmoted(mouse, emote);
        }

      

}
