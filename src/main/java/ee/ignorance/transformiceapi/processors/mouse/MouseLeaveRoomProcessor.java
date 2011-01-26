package ee.ignorance.transformiceapi.processors.mouse;

import ee.ignorance.transformiceapi.Mouse;
import ee.ignorance.transformiceapi.PlayerImpl;
import ee.ignorance.transformiceapi.processors.CommandProcessor;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.mouse.MouseLeaveRoomResponse;


public class MouseLeaveRoomProcessor  extends CommandProcessor{

	@Override
	public void process(AbstractResponse command, PlayerImpl player) {
		MouseLeaveRoomResponse response = (MouseLeaveRoomResponse) command;
                Mouse mouse = player.getMouseById(response.getMouseID());
                player.getRoomMice().remove(mouse);
	}
}
