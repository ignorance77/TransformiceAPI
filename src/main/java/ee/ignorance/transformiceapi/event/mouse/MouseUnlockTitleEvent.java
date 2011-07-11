package ee.ignorance.transformiceapi.event.mouse;

import ee.ignorance.transformiceapi.Mouse;
import ee.ignorance.transformiceapi.event.Event;
import ee.ignorance.transformiceapi.titles.Title;

public class MouseUnlockTitleEvent implements Event<MouseUnlockTitleListener> {

	private Mouse mouse;
	private Title title;

	public MouseUnlockTitleEvent(Mouse mouse, Title title) {
		this.mouse = mouse;
		this.title = title;
	}

	public Mouse getMouse() {
		return mouse;
	}

	public Title getTitle() {
		return title;
	}

	@Override
	public void notifyListener(MouseUnlockTitleListener listener) {
		listener.mouseUnlockedTitle(mouse, title);
	}
}
