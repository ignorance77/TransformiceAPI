package ee.ignorance.transformiceapi.processors.mouse;

import ee.ignorance.transformiceapi.Mouse;
import ee.ignorance.transformiceapi.PlayerImpl;
import ee.ignorance.transformiceapi.event.mouse.MouseEmoteEvent;
import ee.ignorance.transformiceapi.processors.CommandProcessor;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.mouse.MouseEmoteResponse;


public class MouseEmoteProcessor  extends CommandProcessor{

        @Override
        public void process(AbstractResponse command, PlayerImpl player) {
            MouseEmoteResponse response = (MouseEmoteResponse) command;
            Mouse mouse = player.getMouseById(response.getMouseID());
            if(mouse != null)
            {
                    mouse.setEmote(response.getEmote());
                    player.notifyListeners(new MouseEmoteEvent(mouse));
            }
        }
}
