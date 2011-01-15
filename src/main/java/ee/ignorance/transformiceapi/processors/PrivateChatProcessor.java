package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.PlayerImpl;
import ee.ignorance.transformiceapi.event.PrivateChatEvent;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.PrivateChatResponse;


public class PrivateChatProcessor extends CommandProcessor{
    @Override
    public void process(AbstractResponse command, PlayerImpl player) {
        PrivateChatResponse response = (PrivateChatResponse) command;
        player.notifyListeners(new PrivateChatEvent(response.getSender(), response.getMessage()));
    }

}
