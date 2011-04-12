package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.Mouse;
import ee.ignorance.transformiceapi.PlayerImpl;
import ee.ignorance.transformiceapi.event.ShamanChangeEvent;
import ee.ignorance.transformiceapi.event.ShamanStatusEvent;
import ee.ignorance.transformiceapi.protocol.server.ShamanStatusResponse;

public class ShamanStatusProcessor extends AbstractProcessor<ShamanStatusResponse> {

        @Override
        public void process(ShamanStatusResponse response, GameConnection connection) {
                PlayerImpl player = connection.getPlayer();

                if (response.getShamanCode() == player.getMouseId()) {
                        player.setShaman(true);
                        player.notifyListeners(new ShamanStatusEvent());

                } else {
                        player.setShaman(false);
                }

                Mouse firstShaman = player.getMouseById(response.getShamanCode());
                if (firstShaman == null) {
                        return;
                }

                if (response.isTwoShamans()) {
                        player.setSecondShamanCode(response.getSecondShamanCode());
                        if (player.getSecondShamanCode() == player.getMouseId()) {
                                player.setShaman(true);
                        }

                        Mouse secondShaman = player.getMouseById(response.getSecondShamanCode());
                        if (secondShaman != null) {
                                player.notifyListeners(new ShamanChangeEvent(firstShaman, secondShaman, true));
                        }
                } else {
                        player.setSecondShamanCode(null);
                        player.notifyListeners(new ShamanChangeEvent(firstShaman, null, false));
                }
        }
}
