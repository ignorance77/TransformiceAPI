package ee.ignorance.transformiceapi.processors.mouse;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.Mouse;
import ee.ignorance.transformiceapi.PlayerImpl;
import ee.ignorance.transformiceapi.event.mouse.MouseBalloonEvent;
import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.protocol.server.mouse.MouseBalloonResponse;

public class MouseBalloonProcessor extends AbstractProcessor<MouseBalloonResponse> {

        @Override
        public void process(MouseBalloonResponse response, GameConnection connection) {
                PlayerImpl player = connection.getPlayer();

                Mouse mouse = player.getMouseById(response.getMouseID());
                if (mouse != null) {
                        mouse.setBallonAttached(response.isBalloonAttached());
                        player.notifyListeners(new MouseBalloonEvent(mouse));
                }
        }
}
