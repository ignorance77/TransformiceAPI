package ee.ignorance.transformiceapi.processors.mouse;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.Mouse;
import ee.ignorance.transformiceapi.PlayerImpl;
import ee.ignorance.transformiceapi.event.mouse.MouseUnlockTitleEvent;
import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.protocol.server.mouse.MouseUnlockTitleResponse;
import ee.ignorance.transformiceapi.titles.Title;
import ee.ignorance.transformiceapi.titles.Titles;

public class MouseUnlockTitleProcessor extends AbstractProcessor<MouseUnlockTitleResponse> {

	@Override
	public void process(MouseUnlockTitleResponse response, GameConnection connection) {
		PlayerImpl player = connection.getPlayer();

		Mouse mouse = player.getMouseById(response.getMouseID());
		Title title = Titles.getTitle(response.getTitleID());
		if (mouse != null && title != null) {
			player.notifyListeners(new MouseUnlockTitleEvent(mouse, title));
		}
	}
}
