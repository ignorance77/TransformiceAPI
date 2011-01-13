/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.Player;
import ee.ignorance.transformiceapi.event.ModChatMessageEvent;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.ModChatMessageResponse;

/**
 *
 * @author user
 */
public class ModChatMessageProcessor extends CommandProcessor{

    @Override
    public void process(AbstractResponse command, Player player) {
        ModChatMessageResponse response = (ModChatMessageResponse) command;
        player.notifyListeners(new ModChatMessageEvent(response.getSender(), response.getMessage()));
    }


}
