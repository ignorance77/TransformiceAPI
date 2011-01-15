package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.PlayerImpl;
import ee.ignorance.transformiceapi.event.MouseDeathEvent;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.MouseDeathResponse;


public class MouseDeathProcessor extends CommandProcessor{

    @Override
    public void process(AbstractResponse command, PlayerImpl player) {
    	MouseDeathResponse response = (MouseDeathResponse) command;
    	player.notifyListeners(new MouseDeathEvent(response.getMouseID(),
                player.getMouseByID(response.getMouseID()).getName()));
    }


}
