package ee.ignorance.transformiceapi.event.mouse;

import ee.ignorance.transformiceapi.Mouse;
import ee.ignorance.transformiceapi.event.Event;

public class MouseJoinRoomEvent implements Event<MouseJoinRoomListener> {

        private Mouse mouse;

        public MouseJoinRoomEvent(Mouse mouse) {
                this.mouse = mouse;
        }

        public Mouse getMouse() {
                return mouse;
        }

        @Override
        public void notifyListener(MouseJoinRoomListener listener) {
                listener.mouseJoinedRoom(mouse);
        }
}
