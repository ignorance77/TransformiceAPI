package ee.ignorance.transformiceapi.processors.mouse;

import ee.ignorance.transformiceapi.Mouse;
import ee.ignorance.transformiceapi.PlayerImpl;
import ee.ignorance.transformiceapi.event.mouse.MouseBalloonEvent;
import ee.ignorance.transformiceapi.processors.CommandProcessor;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.mouse.MouseBalloonResponse;


public class MouseBalloonProcessor  extends CommandProcessor{

        @Override
        public void process(AbstractResponse command, PlayerImpl player) {
            MouseBalloonResponse response = (MouseBalloonResponse) command;
            Mouse mouse = player.getMouseById(response.getMouseID());
            if(mouse != null)
            {
                    mouse.setBallonAttached(response.isBalloonAttached());
                    player.notifyListeners(new MouseBalloonEvent(mouse));
            }
        }
}
