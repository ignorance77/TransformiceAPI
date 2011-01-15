package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.Player;
import ee.ignorance.transformiceapi.event.MapXMLEvent;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.StartGameResponse;

public class StartGameResponseProcessor extends CommandProcessor {

	@Override
	public void process(AbstractResponse command, Player player) {
		StartGameResponse response = (StartGameResponse) command;
		player.setGameCode(response.getGameCode());
                player.notifyListeners(new MapXMLEvent(response.getMapMaker(), response.getMapXML()));
	}

}
