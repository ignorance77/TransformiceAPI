package ee.ignorance.transformiceapi.protocol.server;

import java.util.List;

public class MusicPlayedResponse extends AbstractResponse {

        private String musicURL;

        public MusicPlayedResponse(List<String> rawMessage) {
                super(rawMessage);
        }

        @Override
        public void parse(List<String> rawMessage) {
                setMusicURL(rawMessage.get(1));
        }

        public String getMusicURL() {
                return musicURL;
        }

        public void setMusicURL(String musicURL) {
                this.musicURL = musicURL;
        }
}
