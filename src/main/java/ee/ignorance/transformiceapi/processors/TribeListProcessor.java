package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.event.TribeListEvent;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.TribeListResponse;

public class TribeListProcessor extends AbstractProcessor {

        @Override
        public void process(AbstractResponse response, GameConnection connection) {
                TribeListResponse resp = (TribeListResponse) response;
                connection.getPlayer().notifyListeners(new TribeListEvent(resp.getTribePlayers()));
        }
}
