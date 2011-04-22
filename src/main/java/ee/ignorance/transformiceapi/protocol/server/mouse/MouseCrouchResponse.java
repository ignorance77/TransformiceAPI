package ee.ignorance.transformiceapi.protocol.server.mouse;

import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.processors.mouse.MouseCrouchProcessor;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import java.util.List;

public class MouseCrouchResponse extends AbstractResponse {

        private int mouseID;

        public MouseCrouchResponse(List<String> rawMessage) {
                super(rawMessage);
        }

        @Override
        public void parse(List<String> rawMessage) {
                if (rawMessage.size() == 3) {
                        mouseID = Integer.valueOf(rawMessage.get(1));
                }
        }

        public int getMouseID() {
                return mouseID;
        }

        @Override
        public AbstractProcessor getProcessor() {
                return new MouseCrouchProcessor();
        }
}
