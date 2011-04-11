package ee.ignorance.transformiceapi.event;

import ee.ignorance.transformiceapi.TribePlayer;

import java.util.List;

public class TribeListEvent implements Event<TribeListListener> {

        private List<TribePlayer> tribePlayers;

        public TribeListEvent(List<TribePlayer> tribePlayers) {
                this.tribePlayers = tribePlayers;
        }

        public List<TribePlayer> getTribePlayers() {
                return tribePlayers;
        }

        @Override
        public void notifyListener(TribeListListener listener) {
                listener.tribeListReceived(tribePlayers);
        }
}
