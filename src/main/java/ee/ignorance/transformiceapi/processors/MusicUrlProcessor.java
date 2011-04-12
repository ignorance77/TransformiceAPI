package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.event.MusicUrlEvent;
import ee.ignorance.transformiceapi.protocol.server.MusicUrlResponse;

public class MusicUrlProcessor extends AbstractProcessor<MusicUrlResponse> {

        @Override
        public void process(MusicUrlResponse response, GameConnection connection) {
                connection.getPlayer().notifyListeners(new MusicUrlEvent(response.getMusicUrl()));
        }
}
