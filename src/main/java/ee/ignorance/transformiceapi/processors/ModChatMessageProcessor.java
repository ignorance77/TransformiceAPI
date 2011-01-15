package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.PlayerImpl;
import ee.ignorance.transformiceapi.event.ModChatMessageEvent;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.ModChatMessageResponse;

public class ModChatMessageProcessor extends CommandProcessor{

    @Override
    public void process(AbstractResponse command, PlayerImpl player) {
        ModChatMessageResponse response = (ModChatMessageResponse) command;
        player.notifyListeners(new ModChatMessageEvent(response.getSender(), response.getMessage()));
    }


}
