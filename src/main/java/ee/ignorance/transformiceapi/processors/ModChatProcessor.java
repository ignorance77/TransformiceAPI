package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.event.ModChatEvent;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.ModChatResponse;

public class ModChatProcessor extends AbstractProcessor {

        @Override
        public void process(AbstractResponse response, GameConnection connection) {
                ModChatResponse resp = (ModChatResponse) response;
                connection.getPlayer().notifyListeners(new ModChatEvent(resp.getSender(), resp.getMessage()));
        }
}