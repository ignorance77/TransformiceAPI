package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.event.NormalChatMessageEvent;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.NormalChatResponse;

public class NormalChatProcessor extends AbstractProcessor {

        @Override
        public void process(AbstractResponse response, GameConnection connection) {
                NormalChatResponse resp = (NormalChatResponse) response;
                connection.getPlayer().notifyListeners(new NormalChatMessageEvent(resp.getSender(), resp.getMessage()));
        }
}
