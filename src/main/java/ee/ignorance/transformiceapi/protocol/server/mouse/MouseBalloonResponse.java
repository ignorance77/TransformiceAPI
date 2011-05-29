package ee.ignorance.transformiceapi.protocol.server.mouse;

import java.util.List;

import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.processors.mouse.MouseBalloonProcessor;
import ee.ignorance.transformiceapi.protocol.server.Processable;

public final class MouseBalloonResponse implements Processable {

        private int mouseID;
        private boolean balloonAttached;

        public MouseBalloonResponse(List<String> rawMessage) {
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
