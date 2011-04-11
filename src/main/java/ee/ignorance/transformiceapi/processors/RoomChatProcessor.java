package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.event.RoomChatEvent;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.RoomChatResponse;

public class RoomChatProcessor extends AbstractProcessor {

        @Override
        public void process(AbstractResponse response, GameConnection connection) {
                RoomChatResponse resp = (RoomChatResponse) response;
                connection.getPlayer().notifyListeners(new RoomChatEvent(resp.getSender(), resp.getMessage()));
        }
}
