package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.event.PrivateChatEvent;
import ee.ignorance.transformiceapi.protocol.server.PrivateChatResponse;

public class PrivateChatProcessor extends AbstractProcessor<PrivateChatResponse> {

        @Override
        public void process(PrivateChatResponse response, GameConnection connection) {
                if (response.getType() == 1) {  //0 indicates outgoing sent message
                        connection.getPlayer().notifyListeners(new PrivateChatEvent(response.getSender(), response.getMessage()));
                }
        }
}
