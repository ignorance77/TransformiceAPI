package ee.ignorance.transformiceapi.event;

import ee.ignorance.transformiceapi.PlayerProfile;

public interface PlayerProfileListener {

        void playerProfileReceived(PlayerProfile profile);
}
