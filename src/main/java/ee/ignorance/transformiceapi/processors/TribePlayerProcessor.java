package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.Player;
import ee.ignorance.transformiceapi.event.TribePlayerConnectEvent;
import ee.ignorance.transformiceapi.event.TribePlayerDisconnectEvent;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.TribePlayerResponse;


public class TribePlayerProcessor extends CommandProcessor{

    @Override
    public void process(AbstractResponse command, Player player) {
        TribePlayerResponse response = (TribePlayerResponse) command;
        if(response.getType() == 1){
            player.notifyListeners(new TribePlayerConnectEvent(response.getPlayerName()));
        }
        if(response.getType() == 2){
            player.notifyListeners(new TribePlayerDisconnectEvent(response.getPlayerName()));
        }
    }
}
