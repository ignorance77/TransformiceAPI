package ee.ignorance.transformiceapi.event;

public class TribePlayerQuitEvent implements Event<TribePlayerQuitListener> {

        private String playerName;

        public TribePlayerQuitEvent(String playerName) {
                this.playerName = playerName;
        }

        public String getPlayerName() {
                return playerName;
        }

        @Override
        public void notifyListener(TribePlayerQuitListener listener) {
                listener.tribePlayerQuit(playerName);
        }
}
