package ee.ignorance.transformiceapi.processors.mouse;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.Mouse;
import ee.ignorance.transformiceapi.PlayerImpl;
import ee.ignorance.transformiceapi.event.mouse.MouseDeathEvent;
import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.protocol.server.mouse.MouseDeathResponse;

public class MouseDeathProcessor extends AbstractProcessor<MouseDeathResponse> {

        @Override
        public void process(MouseDeathResponse response, GameConnection connection) {
                PlayerImpl player = connection.getPlayer();

                Mouse deadMouse = player.getMouseById(response.getMouseID());
                if (deadMouse != null) {
                        deadMouse.setDead(true);
                        player.notifyListeners(new MouseDeathEvent(deadMouse));
                }
        }
}
