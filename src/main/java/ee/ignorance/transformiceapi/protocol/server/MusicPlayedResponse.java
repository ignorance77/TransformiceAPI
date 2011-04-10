package ee.ignorance.transformiceapi.protocol.server;

import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.processors.MusicPlayedProcessor;

import java.util.List;

public class MusicPlayedResponse extends AbstractResponse {

        private String musicURL;

        public MusicPlayedResponse(List<String> rawMessage) {
                super(rawMessage);
        }

        @Override
        public void parse(List<String> rawMessage) {
                musicURL = rawMessage.get(1);
        }

        public String getMusicURL() {
                return musicURL;
        }

        @Override
        public AbstractProcessor getProcessor() {
                return new MusicPlayedProcessor();
        }
}
