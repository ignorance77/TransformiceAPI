package ee.ignorance.transformiceapi.protocol.server;

import java.util.List;

import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.processors.IntroduceProcessor;

public final class IntroduceResponse implements Processable {

        private String hashedBytes;

        public IntroduceResponse(List<String> rawMessage) {
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
