package ee.ignorance.transformiceapi.processors.mouse;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.PlayerImpl;
import ee.ignorance.transformiceapi.event.RoundStartEvent;
import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.protocol.server.mouse.MouseListResponse;

public class MouseListProcessor extends AbstractProcessor<MouseListResponse> {

        @Override
        public void process(MouseListResponse response, GameConnection connection) {
        	PlayerImpl player = connection.getPlayer();
            player.setRoomMice(response.getMice());
            player.notifyListeners(new RoundStartEvent());
        }
}
