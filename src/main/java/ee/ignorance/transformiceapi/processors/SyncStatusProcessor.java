package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.Mouse;
import ee.ignorance.transformiceapi.PlayerImpl;
import ee.ignorance.transformiceapi.event.SyncChangedEvent;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.SyncStatusResponse;

public class SyncStatusProcessor extends AbstractProcessor {

        @Override
        public void process(AbstractResponse response, GameConnection connection) {
                SyncStatusResponse resp = (SyncStatusResponse) response;
                PlayerImpl player = connection.getPlayer();
                player.setSyncStatus(resp.getCodeSync() == player.getMouseId());

                for (Mouse currentMouse : player.getRoomMice()) {
                        if (currentMouse.getCode() == resp.getCodeSync()) {
                                player.notifyListeners(new SyncChangedEvent(currentMouse.getName()));
                        }
                }
        }
}
