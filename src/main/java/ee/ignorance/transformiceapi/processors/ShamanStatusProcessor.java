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

                if (response.getShamanCode() == player.getMouseId() ||
                		response.getSecondShamanCode() == player.getMouseId()) {
                	player.setShaman(true);
                	player.notifyListeners(new ShamanStatusEvent());
                } else {
                	player.setShaman(false);
                }
                
                if (!response.isTwoShamans()) {
                	Mouse first = player.getMouseById(response.getShamanCode());
                	if (first != null) {
                		player.notifyListeners(new ShamanChangeEvent(first, null, false));
                	}
                } else {
                	Mouse first = player.getMouseById(response.getShamanCode());
                	Mouse second = player.getMouseById(response.getSecondShamanCode());
                	if (first != null && second != null) {
                		player.notifyListeners(new ShamanChangeEvent(first, second, true));
                	}
                }        
        }
}
