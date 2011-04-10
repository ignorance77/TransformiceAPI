package ee.ignorance.transformiceapi.processors.mouse;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.PlayerImpl;
import ee.ignorance.transformiceapi.event.mouse.MouseJoinRoomEvent;
import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.mouse.MouseJoinRoomResponse;

public class MouseJoinRoomProcessor extends AbstractProcessor {

        @Override
        public void process(AbstractResponse response, GameConnection connection) {
                MouseJoinRoomResponse resp = (MouseJoinRoomResponse) response;

                PlayerImpl player = connection.getPlayer();
                player.getRoomMice().add(resp.getMouse());
                player.notifyListeners(new MouseJoinRoomEvent(resp.getMouse()));
        }
}
