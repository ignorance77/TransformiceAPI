package ee.ignorance.transformiceapi.processors.mouse;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.Mouse;
import ee.ignorance.transformiceapi.PlayerImpl;
import ee.ignorance.transformiceapi.event.mouse.MouseBalloonEvent;
import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.mouse.MouseBalloonResponse;

public class MouseBalloonProcessor extends AbstractProcessor {

        @Override
        public void process(AbstractResponse response, GameConnection connection) {
                MouseBalloonResponse resp = (MouseBalloonResponse) response;
                PlayerImpl player = connection.getPlayer();

                Mouse mouse = player.getMouseById(resp.getMouseID());
                if (mouse != null) {
                        mouse.setBallonAttached(resp.isBalloonAttached());
                        player.notifyListeners(new MouseBalloonEvent(mouse));
                }
        }
}
