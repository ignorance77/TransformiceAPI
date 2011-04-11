package ee.ignorance.transformiceapi.event;

import ee.ignorance.transformiceapi.TribePlayer;

import java.util.List;

public interface TribeListListener {

        void tribeListReceived(List<TribePlayer> playerList);
}
