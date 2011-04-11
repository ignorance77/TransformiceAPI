package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.event.MusicUrlEvent;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.MusicUrlResponse;

public class MusicUrlProcessor extends AbstractProcessor {

        @Override
        public void process(AbstractResponse response, GameConnection connection) {
                MusicUrlResponse resp = (MusicUrlResponse) response;
                connection.getPlayer().notifyListeners(new MusicUrlEvent(resp.getMusicUrl()));
        }
}
