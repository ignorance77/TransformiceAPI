package ee.ignorance.transformiceapi.protocol.server.mouse;

import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.processors.mouse.MouseDeathProcessor;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;

import java.util.List;

public class MouseDeathResponse extends AbstractResponse {

        private int mouseID;

        public MouseDeathResponse(List<String> rawMessage) {
                super(rawMessage);
        }

        @Override
        public void parse(List<String> rawMessage) {
                mouseID = Integer.valueOf(rawMessage.get(1));
        }

        public int getMouseID() {
                return mouseID;
        }

        @Override
        public AbstractProcessor getProcessor() {
                return new MouseDeathProcessor();
        }
}
