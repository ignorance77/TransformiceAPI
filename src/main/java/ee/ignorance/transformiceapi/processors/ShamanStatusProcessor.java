package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.Mouse;
import ee.ignorance.transformiceapi.PlayerImpl;
import ee.ignorance.transformiceapi.event.ShamanChangeEvent;
import ee.ignorance.transformiceapi.event.ShamanStatusEvent;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.ShamanStatusResponse;

public class ShamanStatusProcessor extends AbstractProcessor {

        @Override
        public void process(AbstractResponse response, GameConnection connection) {
                ShamanStatusResponse resp = (ShamanStatusResponse) response;
                PlayerImpl player = connection.getPlayer();

                if (resp.getShamanCode() == player.getMouseId()) {
                        player.setShaman(true);
                        player.notifyListeners(new ShamanStatusEvent());
                        
                } else {
                        player.setShaman(false);
                }

                Mouse firstShaman = player.getMouseById(resp.getShamanCode());
                if (firstShaman == null) return;

                if (resp.isTwoShamans()) {
                        player.setSecondShamanCode(resp.getSecondShamanCode());
                        if (player.getSecondShamanCode() == player.getMouseId()) {
                                player.setShaman(true);
                        }

                        Mouse secondShaman = player.getMouseById(resp.getSecondShamanCode());
                        if (secondShaman != null) {
                                player.notifyListeners(new ShamanChangeEvent(firstShaman, secondShaman, true));
                        }      
                } else {
                        player.setSecondShamanCode(null);
                        player.notifyListeners(new ShamanChangeEvent(firstShaman, null, false));
                }
        }
}
