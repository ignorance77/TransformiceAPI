package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.GameConnection;
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
                        player.notifyListeners(new ShamanStatusEvent());
                        player.setShaman(true);
                } else {
                        player.setShaman(false);
                }
                player.notifyListeners(new ShamanChangeEvent(resp.getShamanCode(), resp.getSecondShamanCode()));
                if (resp.isTwoShamans()) {
                        player.setSecondShamanCode(resp.getSecondShamanCode());
                        if (player.getSecondShamanCode() == player.getMouseId()) {
                                player.setShaman(true);
                        }
                } else {
                        player.setSecondShamanCode(null);
                }
        }
}
