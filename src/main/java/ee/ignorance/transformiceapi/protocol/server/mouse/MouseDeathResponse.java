package ee.ignorance.transformiceapi.protocol.server.mouse;

import java.util.List;

import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.processors.mouse.MouseDeathProcessor;
import ee.ignorance.transformiceapi.protocol.server.Processable;

public final class MouseDeathResponse implements Processable {

        private int mouseID;

        public MouseDeathResponse(List<String> rawMessage) {
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
