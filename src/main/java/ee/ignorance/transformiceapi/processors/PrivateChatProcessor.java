package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.event.PrivateChatEvent;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.PrivateChatResponse;

public class PrivateChatProcessor extends AbstractProcessor {

        @Override
        public void process(AbstractResponse response, GameConnection connection) {
                PrivateChatResponse resp = (PrivateChatResponse) response;

                if (resp.getType() == 1) {  //0 indicates outgoing sent message
                        connection.getPlayer().notifyListeners(new PrivateChatEvent(resp.getSender(), resp.getMessage()));
                }
        }
}
