package ee.ignorance.transformiceapi.processors.mouse;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.Mouse;
import ee.ignorance.transformiceapi.PlayerImpl;
import ee.ignorance.transformiceapi.event.mouse.MouseMoveEvent;
import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.protocol.server.mouse.MouseMoveResponse;

public class MouseMoveProcessor extends AbstractProcessor<MouseMoveResponse> {

        @Override
        public void process(MouseMoveResponse response, GameConnection connection) {
                PlayerImpl player = connection.getPlayer();

                Mouse mouse = player.getMouseById(response.getPlayerID());
                if (mouse != null) {
                        mouse.setPosX(response.getPosX());
                        mouse.setPosY(response.getPosY());
                        mouse.setMovX(response.getMovX());
                        mouse.setMovY(response.getMovY());
                        mouse.setGoingLeft(response.isGoingLeft());
                        mouse.setGoingRight(response.isGoingRight());
                        mouse.setJumping(response.isJumping());
                        mouse.setJumpingImage(response.getJumpingImage());
                        mouse.setPortalId(response.getPortalId());
                        player.notifyListeners(new MouseMoveEvent(mouse));
                }
        }
}
