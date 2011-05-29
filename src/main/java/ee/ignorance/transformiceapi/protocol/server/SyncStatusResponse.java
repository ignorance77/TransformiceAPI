package ee.ignorance.transformiceapi.protocol.server;

import java.util.List;

import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.processors.SyncStatusProcessor;

public final class SyncStatusResponse implements Processable {

        private int codeSync;

        public SyncStatusResponse(List<String> rawMessage) {
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
