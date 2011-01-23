package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.Mouse;
import ee.ignorance.transformiceapi.PlayerImpl;
import ee.ignorance.transformiceapi.event.MouseFinishEvent;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.MouseFinishResponse;


public class MouseFinishProcessor extends CommandProcessor{

    @Override
    public void process(AbstractResponse command, PlayerImpl player) {
    	MouseFinishResponse response = (MouseFinishResponse) command;
        Mouse mouse = player.getMouseById(response.getMouseID());
        if(mouse != null){
                mouse.setHasFinished(true);
                mouse.setFinishedTime(response.getFinishTime());
                mouse.setStanding(response.getStanding());
                player.notifyListeners(new MouseFinishEvent(mouse));
        }
    }


}
