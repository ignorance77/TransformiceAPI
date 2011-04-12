package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.event.TribeListEvent;
import ee.ignorance.transformiceapi.protocol.server.TribeListResponse;

public class TribeListProcessor extends AbstractProcessor<TribeListResponse> {

        @Override
        public void process(TribeListResponse response, GameConnection connection) {
                connection.getPlayer().notifyListeners(new TribeListEvent(response.getTribePlayers()));
        }
}
