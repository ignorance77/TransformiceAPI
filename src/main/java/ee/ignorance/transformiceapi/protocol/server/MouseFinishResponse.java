package ee.ignorance.transformiceapi.protocol.server;

import java.util.List;

public class MouseFinishResponse extends AbstractResponse {

	private int mouseID;
	private int standing;
	private double finishTime;

	public MouseFinishResponse(List<String> rawMessage) {
		super(rawMessage);
	}

	@Override
	public void parse(List<String> rawMessage) {
		setMouseID(Integer.valueOf(rawMessage.get(1).trim()));
		setStanding(Integer.valueOf(rawMessage.get(4).trim()));
		setFinishTime(Integer.valueOf(rawMessage.get(5).trim()) / 10.0);
	}

	public int getMouseID() {
		return mouseID;
	}

	public void setMouseID(int mouseID) {
		this.mouseID = mouseID;
	}

	public double getFinishTime() {
		return finishTime;
	}

	public void setMouseID(double finishTime) {
		this.finishTime = finishTime;
	}

	public int getStanding() {
		return standing;
	}

	public void setStanding(int standing) {
		this.standing = standing;
	}

	public void setFinishTime(double finishTime) {
		this.finishTime = finishTime;
	}
}
