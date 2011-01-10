/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.Player;
import ee.ignorance.transformiceapi.event.ModChatEvent;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.ModChatResponse;

/**
 *
 * @author user
 */
public class ModChatProcessor extends CommandProcessor{

    @Override
    public void process(AbstractResponse command, Player player) {
        ModChatResponse response = (ModChatResponse) command;
        player.notifyListeners(new ModChatEvent(response.getMessage()));
    }


}
