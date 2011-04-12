package ee.ignorance.transformiceapi.processors.mouse;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.Mouse;
import ee.ignorance.transformiceapi.PlayerImpl;
import ee.ignorance.transformiceapi.event.mouse.MouseGotCheeseEvent;
import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.protocol.server.mouse.MouseGotCheeseResponse;

public class MouseGotCheeseProcessor extends AbstractProcessor<MouseGotCheeseResponse> {

        @Override
        public void process(MouseGotCheeseResponse response, GameConnection connection) {
                PlayerImpl player = connection.getPlayer();

                Mouse mouse = player.getMouseById(response.getMouseID());
                if (mouse != null) {
                        player.notifyListeners(new MouseGotCheeseEvent(mouse));

                }
                ;
        }
}
