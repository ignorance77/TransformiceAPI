package ee.ignorance.transformiceapi.processors.mouse;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.Mouse;
import ee.ignorance.transformiceapi.PlayerImpl;
import ee.ignorance.transformiceapi.event.mouse.MouseEmoteEvent;
import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.protocol.server.mouse.MouseEmoteResponse;

public class MouseEmoteProcessor extends AbstractProcessor<MouseEmoteResponse> {

        @Override
        public void process(MouseEmoteResponse response, GameConnection connection) {
                PlayerImpl player = connection.getPlayer();

                Mouse mouse = player.getMouseById(response.getMouseID());
                if (mouse != null) {
                        mouse.setEmote(response.getEmote());
                        player.notifyListeners(new MouseEmoteEvent(mouse));
                }
        }
}
