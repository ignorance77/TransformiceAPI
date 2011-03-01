package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.PlayerImpl;
import ee.ignorance.transformiceapi.event.TribeListEvent;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.TribeListResponse;


public class TribeListProcessor extends CommandProcessor{
    @Override
    public void process(AbstractResponse command, PlayerImpl player) {
        TribeListResponse response = (TribeListResponse) command;
        player.notifyListeners(new TribeListEvent(response.getTribePlayers()));
    }

}
