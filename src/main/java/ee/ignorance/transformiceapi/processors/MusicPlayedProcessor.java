package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.PlayerImpl;
import ee.ignorance.transformiceapi.event.MusicPlayedEvent;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.MusicPlayedResponse;

public class MusicPlayedProcessor extends CommandProcessor{

    @Override
    public void process(AbstractResponse command, PlayerImpl player) {
        MusicPlayedResponse response = (MusicPlayedResponse) command;
        player.notifyListeners(new MusicPlayedEvent(response.getMusicURL()));
    }
}
