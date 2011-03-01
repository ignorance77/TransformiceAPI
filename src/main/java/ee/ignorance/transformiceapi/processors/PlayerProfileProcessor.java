package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.PlayerImpl;
import ee.ignorance.transformiceapi.event.PlayerProfileEvent;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.PlayerProfileResponse;


public class PlayerProfileProcessor extends CommandProcessor{
    @Override
    public void process(AbstractResponse command, PlayerImpl player) {
        PlayerProfileResponse response = (PlayerProfileResponse) command;
        player.notifyListeners(new PlayerProfileEvent(response.getPlayerProfile()));
    }

}
