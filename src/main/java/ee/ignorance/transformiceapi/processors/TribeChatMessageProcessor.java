package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.event.TribeChatMessageEvent;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.TribeChatMessageResponse;

public class TribeChatMessageProcessor extends AbstractProcessor {

        @Override
        public void process(AbstractResponse response, GameConnection connection) {
                TribeChatMessageResponse resp = (TribeChatMessageResponse) response;
                connection.getPlayer().notifyListeners(new TribeChatMessageEvent(resp.getSender(), resp.getMessage()));
        }
}
