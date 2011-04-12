package ee.ignorance.transformiceapi.processors.mouse;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.protocol.server.mouse.MouseListResponse;

public class MouseListProcessor extends AbstractProcessor<MouseListResponse> {

        @Override
        public void process(MouseListResponse response, GameConnection connection) {
                connection.getPlayer().setRoomMice(response.getMice());
        }
}
