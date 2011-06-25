package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.PlayerImpl;
import ee.ignorance.transformiceapi.event.TribePlayerConnectEvent;
import ee.ignorance.transformiceapi.event.TribePlayerDisconnectEvent;
import ee.ignorance.transformiceapi.event.TribePlayerJoinEvent;
import ee.ignorance.transformiceapi.event.TribePlayerQuitEvent;
import ee.ignorance.transformiceapi.event.TribePlayerRankChangeEvent;
import ee.ignorance.transformiceapi.protocol.server.TribePlayerResponse;

public class TribePlayerProcessor extends AbstractProcessor<TribePlayerResponse> {

        @Override
        public void process(TribePlayerResponse response, GameConnection connection) {
                PlayerImpl player = connection.getPlayer();

                if (response.getType() == 1) {
                        player.notifyListeners(new TribePlayerConnectEvent(response.getPlayerName()));
                }
                if (response.getType() == 2) {
                        player.notifyListeners(new TribePlayerDisconnectEvent(response.getPlayerName()));
                }
                if (response.getType() == 6) {
                        player.notifyListeners(new TribePlayerJoinEvent(response.getPlayerName()));
                }
                if (response.getType() == 11) {
                        player.notifyListeners(new TribePlayerQuitEvent(response.getPlayerName()));
                }
                if (response.getType() == 12) {
                        player.notifyListeners(new TribePlayerRankChangeEvent(response.getPlayerName(), response.getRank()));
                }
        }
}
