package ee.ignorance.transformiceapi.protocol.server.mouse;

import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import java.util.List;


public class MouseEmoteResponse extends AbstractResponse {

	private int mouseID;
	private int emote;

	public MouseEmoteResponse(List<String> rawMessage) {
		super(rawMessage);
	}

	@Override
	public void parse(List<String> rawMessage) {
		setMouseID(Integer.valueOf(rawMessage.get(1)));
		setEmote(Integer.valueOf(rawMessage.get(2)));
	}


        public int getMouseID() {
		return mouseID;
	}

	public void setMouseID(int mouseID) {
		this.mouseID = mouseID;
	}


	public void setEmote(int emote) {
		this.emote = emote;
	}

	public int getEmote() {
		return emote;
	}
}
