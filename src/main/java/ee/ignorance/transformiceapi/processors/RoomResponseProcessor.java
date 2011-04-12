package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.protocol.server.RoomResponse;

public class RoomResponseProcessor extends AbstractProcessor<RoomResponse> {

        @Override
        public void process(RoomResponse response, GameConnection connection) {
                connection.getPlayer().setRoom(response.getRoom());
        }
}
