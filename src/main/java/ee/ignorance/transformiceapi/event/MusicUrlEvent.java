package ee.ignorance.transformiceapi.event;

public class MusicUrlEvent implements Event<MusicUrlListener> {

        private String musicUrl;

        public MusicUrlEvent(String musicURL) {
                this.musicUrl = musicURL;
        }

        public String getMusicUrl() {
                return musicUrl;
        }

        @Override
        public void notifyListener(MusicUrlListener listener) {
                listener.musicUrlReceived(musicUrl);
        }
}
