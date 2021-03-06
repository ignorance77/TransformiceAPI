package ee.ignorance.transformiceapi.protocol.server.mouse;

import java.util.List;

import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.processors.mouse.MouseGotCheeseProcessor;
import ee.ignorance.transformiceapi.protocol.server.Processable;

public final class MouseGotCheeseResponse implements Processable {

        private int mouseID;

        public MouseGotCheeseResponse(List<String> rawMessage) {
        		mouseID = Integer.parseInt(rawMessage.get(1));
        }

        public int getMouseID() {
                return mouseID;
        }

        @Override
        public AbstractProcessor getProcessor() {
                return new MouseGotCheeseProcessor();
        }
}
