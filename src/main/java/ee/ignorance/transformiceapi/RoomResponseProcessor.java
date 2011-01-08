package ee.ignorance.transformiceapi;

import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.RoomResponse;

public class RoomResponseProcessor extends CommandProcessor {

	@Override
	public void process(AbstractResponse command, Player player) {
		RoomResponse response = (RoomResponse) command;
		player.setRoom(response.getRoom());
	}

}
