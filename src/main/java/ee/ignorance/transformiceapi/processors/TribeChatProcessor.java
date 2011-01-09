package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.Player;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.TribeChatResponse;


public class TribeChatProcessor extends CommandProcessor{

    @Override
    public void process(AbstractResponse command, Player player) {
        TribeChatResponse response = (TribeChatResponse) command;
        player.getListenerHandler().notifyTribeChatListeners(response.getSender(), response.getMessage());
    }

}
