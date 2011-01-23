package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.Mouse;
import ee.ignorance.transformiceapi.PlayerImpl;
import ee.ignorance.transformiceapi.event.MouseMovedEvent;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.MouseMovedResponse;


public class MouseMovedProcessor extends CommandProcessor{

    @Override
    public void process(AbstractResponse command, PlayerImpl player) {
        MouseMovedResponse response = (MouseMovedResponse)command;

        Mouse mouse = player.getMouseById(response.getPlayerID());
        if(mouse != null){
            mouse.setPosX(response.getPosX());
            mouse.setPosY(response.getPosY());
            mouse.setMovX(response.getMovX());
            mouse.setMovY(response.getMovY());
            mouse.setGoingLeft(response.isGoingLeft());
            mouse.setGoingRight(response.isGoingRight());
            mouse.setJumping(response.isJumping());
            mouse.setJumpingImage(response.getJumpingImage());
            mouse.setUnk(response.getUnk());
            player.notifyListeners(new MouseMovedEvent(mouse));
        }
    }
}
