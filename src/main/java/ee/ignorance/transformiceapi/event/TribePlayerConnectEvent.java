package ee.ignorance.transformiceapi.event;

public class TribePlayerConnectEvent implements Event<TribePlayerConnectListener>  {

        private String playerName;

        public TribePlayerConnectEvent(String playerName) {
                this.playerName = playerName;
        }

        public String getPlayerName() {
                return playerName;
        }

        @Override
        public void notifyListener(TribePlayerConnectListener listener) {
                listener.tribePlayerConnected(playerName);
        }
}
