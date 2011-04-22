package ee.ignorance.transformiceapi.processors.mouse;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.Mouse;
import ee.ignorance.transformiceapi.PlayerImpl;
import ee.ignorance.transformiceapi.event.mouse.MouseCrouchEvent;
import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.protocol.server.mouse.MouseCrouchResponse;

public class MouseCrouchProcessor extends AbstractProcessor<MouseCrouchResponse> {

        @Override
        public void process(MouseCrouchResponse response, GameConnection connection) {
                PlayerImpl player = connection.getPlayer();

                Mouse mouse = player.getMouseById(response.getMouseID());
                if (mouse != null) {
                        player.notifyListeners(new MouseCrouchEvent(mouse));
                }
        }
}
