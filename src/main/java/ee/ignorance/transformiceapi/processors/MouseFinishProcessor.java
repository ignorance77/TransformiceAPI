package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.PlayerImpl;
import ee.ignorance.transformiceapi.event.MouseFinishEvent;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.MouseFinishResponse;


public class MouseFinishProcessor extends CommandProcessor{

    @Override
    public void process(AbstractResponse command, PlayerImpl player) {
    	MouseFinishResponse response = (MouseFinishResponse) command;
    	player.notifyListeners(new MouseFinishEvent( response.getMouseID(), response.getStanding(), response.getFinishTime()));
    }


}
