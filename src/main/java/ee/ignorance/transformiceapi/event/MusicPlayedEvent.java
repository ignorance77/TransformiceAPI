package ee.ignorance.transformiceapi.event;


public class MusicPlayedEvent implements Event {
        private String musicURL;

        public MusicPlayedEvent(String musicURL) {
                this.musicURL = musicURL;
        }
        
        public String getMusicURL() {
                return musicURL;
        }

        public void setMusicURL(String musicURL) {
                this.musicURL = musicURL;
        }


}
