package ee.ignorance.transformiceapi.processors.mouse;

import ee.ignorance.transformiceapi.PlayerImpl;
import ee.ignorance.transformiceapi.processors.CommandProcessor;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.mouse.MouseListResponse;

public class MouseListProcessor extends CommandProcessor {

	@Override
	public void process(AbstractResponse command, PlayerImpl player) {
		MouseListResponse response = (MouseListResponse) command;
		player.setRoomMice(response.getMice());
	}

}
