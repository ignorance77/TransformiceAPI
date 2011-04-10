package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.event.PlayerProfileEvent;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.PlayerProfileResponse;

public class PlayerProfileProcessor extends AbstractProcessor {

        @Override
        public void process(AbstractResponse response, GameConnection connection) {
                PlayerProfileResponse resp = (PlayerProfileResponse) response;
                connection.getPlayer().notifyListeners(new PlayerProfileEvent(resp.getPlayerProfile()));
        }
}
