package ee.ignorance.transformiceapi.event;

import ee.ignorance.transformiceapi.PlayerProfile;

public class PlayerProfileEvent implements Event<PlayerProfileListener> {

        private PlayerProfile playerProfile;

        public PlayerProfileEvent(PlayerProfile playerProfile) {
                this.playerProfile = playerProfile;
        }

        public PlayerProfile getPlayerProfile() {
                return playerProfile;
        }

        @Override
        public void notifyListener(PlayerProfileListener listener) {
                listener.playerProfileReceived(playerProfile);
        }
}
