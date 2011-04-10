package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.RoomResponse;

public class RoomResponseProcessor extends AbstractProcessor {

        @Override
        public void process(AbstractResponse response, GameConnection connection) {
                RoomResponse resp = (RoomResponse) response;
                connection.getPlayer().setRoom(resp.getRoom());
        }
}
