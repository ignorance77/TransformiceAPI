package ee.ignorance.transformiceapi.processors.mouse;

import ee.ignorance.transformiceapi.PlayerImpl;
import ee.ignorance.transformiceapi.event.mouse.MouseJoinRoomEvent;
import ee.ignorance.transformiceapi.processors.CommandProcessor;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.mouse.MouseJoinRoomResponse;

public class MouseJoinRoomProcessor extends CommandProcessor {

        @Override
        public void process(AbstractResponse command, PlayerImpl player) {
                MouseJoinRoomResponse response = (MouseJoinRoomResponse) command;
                player.getRoomMice().add(response.getMouse());
                player.notifyListeners(new MouseJoinRoomEvent(response.getMouse()));
        }
}
