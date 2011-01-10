package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.Player;
import ee.ignorance.transformiceapi.event.TribeChatMessageEvent;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.TribeChatResponse;


public class TribeChatProcessor extends CommandProcessor{

    @Override
    public void process(AbstractResponse command, Player player) {
        TribeChatResponse response = (TribeChatResponse) command;
        player.notifyListeners(new TribeChatMessageEvent(response.getSender(), response.getMessage()));
    }

}
