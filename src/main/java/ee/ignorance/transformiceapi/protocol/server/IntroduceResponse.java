package ee.ignorance.transformiceapi.protocol.server;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.processors.IntroduceProcessor;

import java.util.List;

public class IntroduceResponse extends AbstractResponse {

        private String hashedBytes;

        public IntroduceResponse(List<String> rawMessage) {
                super(rawMessage);
        }

        @Override
        public void parse(List<String> rawMessage) {
                hashedBytes = rawMessage.get(1);
        }

        public String getHashedBytes() {
                return hashedBytes;
        }

        @Override
        public AbstractProcessor getProcessor() {
                return new IntroduceProcessor();
        }
}
