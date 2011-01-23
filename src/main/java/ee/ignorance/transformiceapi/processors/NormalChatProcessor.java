package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.PlayerImpl;
import ee.ignorance.transformiceapi.event.NormalChatMessageEvent;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.NormalChatResponse;


public class NormalChatProcessor extends CommandProcessor{

        @Override
        public void process(AbstractResponse command, PlayerImpl player) {
                NormalChatResponse response = (NormalChatResponse) command;
                player.notifyListeners(new NormalChatMessageEvent(response.getSender(), response.getMessage()));
        }
}
