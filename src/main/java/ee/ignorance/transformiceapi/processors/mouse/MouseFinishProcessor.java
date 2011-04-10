package ee.ignorance.transformiceapi.processors.mouse;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.Mouse;
import ee.ignorance.transformiceapi.PlayerImpl;
import ee.ignorance.transformiceapi.event.mouse.MouseFinishEvent;
import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.mouse.MouseFinishResponse;

public class MouseFinishProcessor extends AbstractProcessor {

        @Override
        public void process(AbstractResponse response, GameConnection connection) {
                MouseFinishResponse resp = (MouseFinishResponse) response;
                PlayerImpl player = connection.getPlayer();

                Mouse mouse = player.getMouseById(resp.getMouseID());
                if (mouse != null) {
                        mouse.setHasFinished(true);
                        mouse.setFinishedTime(resp.getFinishTime());
                        mouse.setStanding(resp.getStanding());
                        player.notifyListeners(new MouseFinishEvent(mouse));
                }
        }
}
