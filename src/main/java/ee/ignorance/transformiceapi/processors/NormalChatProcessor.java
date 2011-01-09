package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.Player;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.NormalChatResponse;


public class NormalChatProcessor extends CommandProcessor{

    @Override
    public void process(AbstractResponse command, Player player) {
        NormalChatResponse response = (NormalChatResponse) command;
        player.notifyNormalChatListeners(response.getSender(), response.getMessage());
    }

}
