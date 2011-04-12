package ee.ignorance.transformiceapi.processors.mouse;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.PlayerImpl;
import ee.ignorance.transformiceapi.event.mouse.MouseJoinRoomEvent;
import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.protocol.server.mouse.MouseJoinRoomResponse;

public class MouseJoinRoomProcessor extends AbstractProcessor<MouseJoinRoomResponse> {

        @Override
        public void process(MouseJoinRoomResponse response, GameConnection connection) {
                PlayerImpl player = connection.getPlayer();
                player.getRoomMice().add(response.getMouse());
                player.notifyListeners(new MouseJoinRoomEvent(response.getMouse()));
        }
}
