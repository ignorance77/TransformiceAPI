package ee.ignorance.transformiceapi.protocol.server;

import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.processors.TZATResponseProcessor;

import java.util.List;

public class TZATResponse extends AbstractResponse {

        public TZATResponse(List<String> rawMessage) {
                super(rawMessage);
        }

        @Override
        public void parse(List<String> rawMessage) {
        }

        @Override
        public AbstractProcessor getProcessor() {
                return new TZATResponseProcessor();
        }
}
