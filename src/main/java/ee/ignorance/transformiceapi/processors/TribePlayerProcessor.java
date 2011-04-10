package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.PlayerImpl;
import ee.ignorance.transformiceapi.event.TribePlayerConnectEvent;
import ee.ignorance.transformiceapi.event.TribePlayerDisconnectEvent;
import ee.ignorance.transformiceapi.event.TribePlayerJoinEvent;
import ee.ignorance.transformiceapi.event.TribePlayerQuitEvent;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.TribePlayerResponse;

public class TribePlayerProcessor extends AbstractProcessor {

        @Override
        public void process(AbstractResponse response, GameConnection connection) {
                TribePlayerResponse resp = (TribePlayerResponse) response;
                PlayerImpl player = connection.getPlayer();

                if (resp.getType() == 1) {
                        player.notifyListeners(new TribePlayerConnectEvent(resp.getPlayerName()));
                }
                if (resp.getType() == 2) {
                        player.notifyListeners(new TribePlayerDisconnectEvent(resp.getPlayerName()));
                }
                if (resp.getType() == 6) {
                        player.notifyListeners(new TribePlayerJoinEvent(resp.getPlayerName()));
                }
                if (resp.getType() == 11) {
                        player.notifyListeners(new TribePlayerQuitEvent(resp.getPlayerName()));
                }
        }
}
