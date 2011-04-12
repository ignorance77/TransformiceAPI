package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.event.RoomChatEvent;
import ee.ignorance.transformiceapi.protocol.server.RoomChatResponse;

public class RoomChatProcessor extends AbstractProcessor<RoomChatResponse> {

        @Override
        public void process(RoomChatResponse response, GameConnection connection) {
                connection.getPlayer().notifyListeners(new RoomChatEvent(response.getSender(), response.getMessage()));
        }
}
