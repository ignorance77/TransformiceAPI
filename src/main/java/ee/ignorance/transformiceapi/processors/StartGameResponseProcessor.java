package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.PlayerImpl;
import ee.ignorance.transformiceapi.event.MapXMLEvent;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.StartGameResponse;

public class StartGameResponseProcessor extends AbstractProcessor {

        @Override
        public void process(AbstractResponse response, GameConnection connection) {
                StartGameResponse resp = (StartGameResponse) response;
                PlayerImpl player = connection.getPlayer();

                player.setGameCode(resp.getGameCode());
                player.notifyListeners(new MapXMLEvent(resp.getMapMaker(), resp.getMapXML()));
        }
}
