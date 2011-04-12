package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.PlayerImpl;
import ee.ignorance.transformiceapi.event.MapXMLEvent;
import ee.ignorance.transformiceapi.protocol.server.StartGameResponse;

public class StartGameResponseProcessor extends AbstractProcessor<StartGameResponse> {

        @Override
        public void process(StartGameResponse response, GameConnection connection) {
                PlayerImpl player = connection.getPlayer();
                player.setGameCode(response.getGameCode());
                player.notifyListeners(new MapXMLEvent(response.getMapMaker(), response.getMapXML()));
        }
}
