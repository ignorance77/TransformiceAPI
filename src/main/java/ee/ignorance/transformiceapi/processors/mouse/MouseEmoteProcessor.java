package ee.ignorance.transformiceapi.processors.mouse;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.Mouse;
import ee.ignorance.transformiceapi.PlayerImpl;
import ee.ignorance.transformiceapi.event.mouse.MouseEmoteEvent;
import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.mouse.MouseEmoteResponse;

public class MouseEmoteProcessor extends AbstractProcessor {

        @Override
        public void process(AbstractResponse response, GameConnection connection) {
                MouseEmoteResponse resp = (MouseEmoteResponse) response;
                PlayerImpl player = connection.getPlayer();
                
                Mouse mouse = player.getMouseById(resp.getMouseID());
                if (mouse != null) {
                        mouse.setEmote(resp.getEmote());
                        player.notifyListeners(new MouseEmoteEvent(mouse, resp.getEmote()));
                }
        }
}
