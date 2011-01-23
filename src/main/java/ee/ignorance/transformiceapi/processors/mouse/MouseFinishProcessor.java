package ee.ignorance.transformiceapi.processors.mouse;

import ee.ignorance.transformiceapi.Mouse;
import ee.ignorance.transformiceapi.PlayerImpl;
import ee.ignorance.transformiceapi.event.mouse.MouseFinishEvent;
import ee.ignorance.transformiceapi.processors.CommandProcessor;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.mouse.MouseFinishResponse;


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
