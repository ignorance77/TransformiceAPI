package ee.ignorance.transformiceapi.protocol.server.mouse;

import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.processors.mouse.MouseGotCheeseProcessor;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;

import java.util.List;

public class MouseGotCheeseResponse extends AbstractResponse {

        private int mouseID;

        public MouseGotCheeseResponse(List<String> rawMessage) {
                super(rawMessage);
        }

        @Override
        public void parse(List<String> rawMessage) {
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
