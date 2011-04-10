package ee.ignorance.transformiceapi.protocol.server.mouse;

import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.processors.mouse.MouseBalloonProcessor;
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
                mouseID = Integer.valueOf(rawMessage.get(1));
                balloonAttached = rawMessage.size() == 2;
        }

        public int getMouseID() {
                return mouseID;
        }

        public boolean isBalloonAttached() {
                return balloonAttached;
        }

        @Override
        public AbstractProcessor getProcessor() {
                return new MouseBalloonProcessor();
        }
}
