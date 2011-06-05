package ee.ignorance.transformiceapi.protocol.server;

import java.util.List;

import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.processors.MusicUrlProcessor;

public final class MusicUrlResponse implements Processable {

        private String musicUrl;

        public MusicUrlResponse(List<String> rawMessage) {
        		musicUrl = rawMessage.get(1);
        }

        public String getMusicUrl() {
                return musicUrl;
        }

        @Override
        public AbstractProcessor getProcessor() {
                return new MusicUrlProcessor();
        }
}
