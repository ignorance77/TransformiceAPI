package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.PlayerImpl;
import ee.ignorance.transformiceapi.event.MouseDeathEvent;
import ee.ignorance.transformiceapi.event.MouseFinishEvent;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.MouseDeathResponse;
import ee.ignorance.transformiceapi.protocol.server.MouseFinishResponse;


public class MouseDeathProcessor extends CommandProcessor{

    @Override
    public void process(AbstractResponse command, PlayerImpl player) {
    	MouseDeathResponse response = (MouseDeathResponse) command;
    	player.notifyListeners(new MouseDeathEvent(response.getMouseID(),
                player.getMouseByID(response.getMouseID()).getName()));
    }


}
