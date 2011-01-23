package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.Mouse;
import ee.ignorance.transformiceapi.PlayerImpl;
import ee.ignorance.transformiceapi.event.MouseDeathEvent;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.MouseDeathResponse;


public class MouseDeathProcessor extends CommandProcessor{

    @Override
    public void process(AbstractResponse command, PlayerImpl player) {
    	MouseDeathResponse response = (MouseDeathResponse) command;
        Mouse deadMouse = player.getMouseById(response.getMouseID());
        if(deadMouse != null)
        {
                deadMouse.setDead(true);
                player.notifyListeners(new MouseDeathEvent(deadMouse));
        }
    }


}
