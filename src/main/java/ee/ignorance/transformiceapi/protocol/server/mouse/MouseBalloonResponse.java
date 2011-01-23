package ee.ignorance.transformiceapi.protocol.server.mouse;

import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import java.util.List;


public class MouseBalloonResponse extends AbstractResponse {

        private int mouseID;
        private boolean balloonAttached;

        public MouseBalloonResponse(List<String> rawMessage) {
                super(rawMessage);
        }

        @Override
        public void parse(List<String> rawMessage) {
                setMouseID(Integer.valueOf(rawMessage.get(1)));
                setBalloonAttached(rawMessage.size() == 2);
        }

        public int getMouseID() {
                return mouseID;
        }

        public void setMouseID(int mouseID) {
                this.mouseID = mouseID;
        }

        public void setBalloonAttached(boolean balloonAttached){
            this.balloonAttached = balloonAttached;
        }

        public boolean isBalloonAttached(){
            return balloonAttached;
        }
}
