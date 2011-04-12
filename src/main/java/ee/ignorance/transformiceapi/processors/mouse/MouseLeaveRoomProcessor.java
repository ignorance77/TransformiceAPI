package ee.ignorance.transformiceapi.processors.mouse;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.Mouse;
import ee.ignorance.transformiceapi.PlayerImpl;
import ee.ignorance.transformiceapi.event.mouse.MouseLeaveRoomEvent;
import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.protocol.server.mouse.MouseLeaveRoomResponse;

public class MouseLeaveRoomProcessor extends AbstractProcessor<MouseLeaveRoomResponse> {

        @Override
        public void process(MouseLeaveRoomResponse response, GameConnection connection) {
                PlayerImpl player = connection.getPlayer();

                Mouse mouse = player.getMouseById(response.getMouseID());
                if (mouse != null) {
                        player.getRoomMice().remove(mouse);
                        player.notifyListeners(new MouseLeaveRoomEvent(mouse));
                }
        }
}
