package ee.ignorance.transformiceapi.event.mouse;

import ee.ignorance.transformiceapi.Mouse;
import ee.ignorance.transformiceapi.event.Event;

public class MouseCrouchEvent implements Event<MouseCrouchListener> {

        private Mouse mouse;
        private boolean crouched;
        
        public MouseCrouchEvent(Mouse mouse, boolean crouched) {
                this.mouse = mouse;
                this.crouched = crouched;
        }

        public Mouse getMouse() {
                return mouse;
        }

        @Override
        public void notifyListener(MouseCrouchListener listener) {
            if (crouched) {
            	listener.mouseCrouched(mouse);	
            } else {
            	listener.mouseStoodUp(mouse);
            } 	
        }
}
