package ee.ignorance.transformiceapi.event;

public class TribePlayerDisconnectEvent implements Event<TribePlayerDisconnectListener> {

        private String playerName;

        public TribePlayerDisconnectEvent(String playerName) {
                this.playerName = playerName;
        }

        public String getPlayerName() {
                return playerName;
        }

        @Override
        public void notifyListener(TribePlayerDisconnectListener listener) {
               listener.tribePlayerDisconnected(playerName);
        }
}
