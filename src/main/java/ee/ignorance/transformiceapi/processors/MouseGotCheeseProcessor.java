package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.Mouse;
import ee.ignorance.transformiceapi.PlayerImpl;
import ee.ignorance.transformiceapi.event.MouseGotCheeseEvent;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.MouseGotCheeseResponse;


public class MouseGotCheeseProcessor extends CommandProcessor{

        @Override
        public void process(AbstractResponse command, PlayerImpl player) {
                MouseGotCheeseResponse response = (MouseGotCheeseResponse) command;
                Mouse mouse = player.getMouseById(response.getMouseID());
                if(mouse != null){
                        player.notifyListeners(new MouseGotCheeseEvent(mouse));

                }
        }
}
