package ee.ignorance.transformiceapi.protocol.server.mouse;

import java.util.List;

import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.processors.mouse.MouseCrouchProcessor;
import ee.ignorance.transformiceapi.protocol.server.Processable;

public final class MouseCrouchResponse implements Processable {

        private int mouseID;

        public MouseCrouchResponse(List<String> rawMessage) {
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
