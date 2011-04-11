package ee.ignorance.transformiceapi.event;

public class TribePlayerJoinEvent implements Event<TribePlayerJoinListener> {

        private String playerName;

        public TribePlayerJoinEvent(String playerName) {
                this.playerName = playerName;
        }

        public String getPlayerName() {
                return playerName;
        }

        @Override
        public void notifyListener(TribePlayerJoinListener listener) {
                listener.tribePlayerJoined(playerName);
        }
}
