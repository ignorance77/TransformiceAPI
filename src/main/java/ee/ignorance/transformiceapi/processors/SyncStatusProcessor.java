package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.Mouse;
import ee.ignorance.transformiceapi.PlayerImpl;
import ee.ignorance.transformiceapi.event.SyncChangeEvent;
import ee.ignorance.transformiceapi.protocol.server.SyncStatusResponse;

public class SyncStatusProcessor extends AbstractProcessor<SyncStatusResponse> {

        @Override
        public void process(SyncStatusResponse response, GameConnection connection) {
                PlayerImpl player = connection.getPlayer();
                player.setSyncStatus(response.getCodeSync() == player.getMouseId());

                for (Mouse currentMouse : player.getRoomMice()) {
                        if (currentMouse.getCode() == response.getCodeSync()) {
                                player.notifyListeners(new SyncChangeEvent(currentMouse.getName()));
                        }
                }
        }
}
