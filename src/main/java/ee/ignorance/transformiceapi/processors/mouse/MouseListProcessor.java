package ee.ignorance.transformiceapi.processors.mouse;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.mouse.MouseListResponse;

public class MouseListProcessor extends AbstractProcessor {

        @Override
        public void process(AbstractResponse response, GameConnection connection) {
                MouseListResponse resp = (MouseListResponse) response;
                connection.getPlayer().setRoomMice(resp.getMice());
        }

}