package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.event.TribeChatEvent;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.TribeChatResponse;

public class TribeChatProcessor extends AbstractProcessor {

        @Override
        public void process(AbstractResponse response, GameConnection connection) {
                TribeChatResponse resp = (TribeChatResponse) response;
                connection.getPlayer().notifyListeners(new TribeChatEvent(resp.getSender(), resp.getMessage()));
        }
}
