package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.Player;
import ee.ignorance.transformiceapi.event.TribePlayerConnectEvent;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.TribePlayerResponse;


public class TribePlayerProcessor extends CommandProcessor{

    @Override
    public void process(AbstractResponse command, Player player) {
        TribePlayerResponse response = (TribePlayerResponse) command;
        if(response.getType() == 1){
            System.out.println("creating TribePlayerConnect");
            player.notifyListeners(new TribePlayerConnectEvent(response.getPlayerName()));
        }
    }
}
