package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.event.ModChatMessageEvent;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.ModChatMessageResponse;

public class ModChatMessageProcessor extends AbstractProcessor {

        @Override
        public void process(AbstractResponse response, GameConnection connection) {
                ModChatMessageResponse resp = (ModChatMessageResponse) response;
                connection.getPlayer().notifyListeners(new ModChatMessageEvent(resp.getSender(), resp.getMessage()));
        }
}