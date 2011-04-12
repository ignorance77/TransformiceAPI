package ee.ignorance.transformiceapi.processors.mouse;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.Mouse;
import ee.ignorance.transformiceapi.PlayerImpl;
import ee.ignorance.transformiceapi.event.mouse.MouseFinishEvent;
import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.protocol.server.mouse.MouseFinishResponse;

public class MouseFinishProcessor extends AbstractProcessor<MouseFinishResponse> {

        @Override
        public void process(MouseFinishResponse response, GameConnection connection) {
                PlayerImpl player = connection.getPlayer();

                Mouse mouse = player.getMouseById(response.getMouseID());
                if (mouse != null) {
                        mouse.setHasFinished(true);
                        mouse.setFinishedTime(response.getFinishTime());
                        mouse.setStanding(response.getStanding());
                        player.notifyListeners(new MouseFinishEvent(mouse));
                }
        }
}
