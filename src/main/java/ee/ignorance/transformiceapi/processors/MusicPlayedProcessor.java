package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.event.MusicPlayedEvent;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.MusicPlayedResponse;

public class MusicPlayedProcessor extends AbstractProcessor {

        @Override
        public void process(AbstractResponse response, GameConnection connection) {
                MusicPlayedResponse resp = (MusicPlayedResponse) response;
                connection.getPlayer().notifyListeners(new MusicPlayedEvent(resp.getMusicURL()));
        }
}
