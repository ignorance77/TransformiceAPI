package ee.ignorance.transformiceapi.protocol.server.mouse;

import java.util.ArrayList;
import java.util.List;

import ee.ignorance.transformiceapi.Mouse;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;

public class MouseListResponse extends AbstractResponse {

	private List<Mouse> mice;

	public MouseListResponse(List<String> rawMessage) {
		super(rawMessage);
	}

	@Override
	public void parse(List<String> rawMessage) {
		List<Mouse> mice = new ArrayList<Mouse>();
		for (int i = 1; i < rawMessage.size(); i++) {
			String[] mouseData = rawMessage.get(i).split("#");
			Mouse mouse = Mouse.parse(mouseData);
			mice.add(mouse);
		}
		setMice(mice);
	}
	
	public List<Mouse> getMice() {
		return mice;
	}

	public void setMice(List<Mouse> mice) {
		this.mice = mice;
	}

}
