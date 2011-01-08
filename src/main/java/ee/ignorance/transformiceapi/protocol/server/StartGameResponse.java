package ee.ignorance.transformiceapi.protocol.server;

import java.util.List;

public class StartGameResponse extends AbstractResponse {

	private String modeNext;
	private String text;
	private String gameCode;
	
	public StartGameResponse(List<String> rawMessage) {
		super(rawMessage);
	}

	@Override
	public void parse(List<String> rawMessage) {
		setModeNext(rawMessage.get(1));
		setText(rawMessage.get(2));
		setGameCode(rawMessage.get(3));
	}

	public String getModeNext() {
		return modeNext;
	}

	public void setModeNext(String modeNext) {
		this.modeNext = modeNext;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getGameCode() {
		return gameCode;
	}

	public void setGameCode(String gameCode) {
		this.gameCode = gameCode;
	}
	
	

}
