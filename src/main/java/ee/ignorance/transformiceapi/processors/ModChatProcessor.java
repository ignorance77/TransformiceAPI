package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.event.ModChatEvent;
import ee.ignorance.transformiceapi.protocol.server.ModChatResponse;

public class ModChatProcessor extends AbstractProcessor<ModChatResponse> {

        @Override
        public void process(ModChatResponse response, GameConnection connection) {
                connection.getPlayer().notifyListeners(new ModChatEvent(response.getSender(), response.getMessage()));
        }
}
