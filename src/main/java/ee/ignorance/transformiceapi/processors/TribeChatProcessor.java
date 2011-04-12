package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.event.TribeChatEvent;
import ee.ignorance.transformiceapi.protocol.server.TribeChatResponse;

public class TribeChatProcessor extends AbstractProcessor<TribeChatResponse> {

        @Override
        public void process(TribeChatResponse response, GameConnection connection) {
                connection.getPlayer().notifyListeners(new TribeChatEvent(response.getSender(), response.getMessage()));
        }
}
