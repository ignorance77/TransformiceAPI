package ee.ignorance.transformiceapi.protocol.server;

import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.processors.MusicUrlProcessor;

import java.util.List;

public class MusicUrlResponse extends AbstractResponse {

        private String musicUrl;

        public MusicUrlResponse(List<String> rawMessage) {
                super(rawMessage);
        }

        @Override
        public void parse(List<String> rawMessage) {
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
