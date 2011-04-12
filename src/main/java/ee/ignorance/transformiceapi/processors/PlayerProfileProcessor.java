package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.event.PlayerProfileEvent;
import ee.ignorance.transformiceapi.protocol.server.PlayerProfileResponse;

public class PlayerProfileProcessor extends AbstractProcessor<PlayerProfileResponse> {

        @Override
        public void process(PlayerProfileResponse response, GameConnection connection) {
                connection.getPlayer().notifyListeners(new PlayerProfileEvent(response.getPlayerProfile()));
        }
}
