package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.Player;
import ee.ignorance.transformiceapi.event.ShamanChangeEvent;
import ee.ignorance.transformiceapi.event.ShamanStatusEvent;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.ShamanStatusResponse;

public class ShamanStatusProcessor extends CommandProcessor {

	@Override
	public void process(AbstractResponse command, Player player) {
		ShamanStatusResponse response = (ShamanStatusResponse) command;
		if (response.getShamanCode() == player.getMouseId()) {
			player.notifyListeners(new ShamanStatusEvent());
			player.setShaman(true);
		} else {
			player.setShaman(false);
		}
		player.notifyListeners(new ShamanChangeEvent(response.getShamanCode(), response.getSecondShamanCode()));
		if (response.isTwoShamans()) {
			player.setSecondShamanCode(response.getSecondShamanCode());
		} else {
			player.setSecondShamanCode(null);
		}
	}

}
