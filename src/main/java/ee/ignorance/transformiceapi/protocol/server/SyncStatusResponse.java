package ee.ignorance.transformiceapi.protocol.server;

import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.processors.SyncStatusProcessor;

import java.util.List;

public class SyncStatusResponse extends AbstractResponse {

        private int codeSync;

        public SyncStatusResponse(List<String> rawMessage) {
                super(rawMessage);
        }

        @Override
        public void parse(List<String> rawMessage) {
                codeSync = Integer.parseInt(rawMessage.get(1));

        }

        public int getCodeSync() {
                return codeSync;
        }

        @Override
        public AbstractProcessor getProcessor() {
                return new SyncStatusProcessor();
        }
}
