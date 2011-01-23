package ee.ignorance.transformiceapi.processors.mouse;

import ee.ignorance.transformiceapi.Mouse;
import ee.ignorance.transformiceapi.PlayerImpl;
import ee.ignorance.transformiceapi.event.mouse.MouseDeathEvent;
import ee.ignorance.transformiceapi.processors.CommandProcessor;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.mouse.MouseDeathResponse;


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
