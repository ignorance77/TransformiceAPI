package ee.ignorance.transformiceapi.processors.mouse;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.Mouse;
import ee.ignorance.transformiceapi.PlayerImpl;
import ee.ignorance.transformiceapi.event.mouse.MouseMovedEvent;
import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.mouse.MouseMovedResponse;

public class MouseMovedProcessor extends AbstractProcessor {

        @Override
        public void process(AbstractResponse response, GameConnection connection) {
                MouseMovedResponse resp = (MouseMovedResponse) response;
                PlayerImpl player = connection.getPlayer();

                Mouse mouse = player.getMouseById(resp.getPlayerID());
                if (mouse != null) {
                        mouse.setPosX(resp.getPosX());
                        mouse.setPosY(resp.getPosY());
                        mouse.setMovX(resp.getMovX());
                        mouse.setMovY(resp.getMovY());
                        mouse.setGoingLeft(resp.isGoingLeft());
                        mouse.setGoingRight(resp.isGoingRight());
                        mouse.setJumping(resp.isJumping());
                        mouse.setJumpingImage(resp.getJumpingImage());
                        mouse.setUnk(resp.getUnk());
                        player.notifyListeners(new MouseMovedEvent(mouse));
                }
        }
}
