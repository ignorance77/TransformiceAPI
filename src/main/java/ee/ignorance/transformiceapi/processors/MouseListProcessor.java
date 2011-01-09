package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.Player;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.MouseListResponse;

public class MouseListProcessor extends CommandProcessor {

	@Override
	public void process(AbstractResponse command, Player player) {
		MouseListResponse response = (MouseListResponse) command;
		player.setRoomMice(response.getMice());
	}

}
