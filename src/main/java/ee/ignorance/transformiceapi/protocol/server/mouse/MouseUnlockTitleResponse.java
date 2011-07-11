package ee.ignorance.transformiceapi.protocol.server.mouse;

import java.util.List;

import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.processors.mouse.MouseUnlockTitleProcessor;
import ee.ignorance.transformiceapi.protocol.server.Processable;

public final class MouseUnlockTitleResponse implements Processable {

	private int mouseID;
	private int titleID;

	public MouseUnlockTitleResponse(List<String> rawMessage) {
		mouseID = Integer.parseInt(rawMessage.get(1));
		titleID = Integer.parseInt(rawMessage.get(2));
	}

	public int getMouseID() {
		return mouseID;
	}

	public int getTitleID() {
		return titleID;
	}

	@Override
	public AbstractProcessor getProcessor() {
		return new MouseUnlockTitleProcessor();
	}
}
