package ee.ignorance.transformiceapi.event;

public class MouseFinishEvent implements Event {

	private int mouseId;
	private int standing;
	private double finishTime;
	
	public MouseFinishEvent(int mouseId, int standing, double finishTime) {
		super();
		this.mouseId = mouseId;
		this.standing = standing;
		this.finishTime = finishTime;
	}
	
	public int getMouseId() {
		return mouseId;
	}
	
	public void setMouseId(int mouseId) {
		this.mouseId = mouseId;
	}
	
	public int getStanding() {
		return standing;
	}
	
	public void setStanding(int standing) {
		this.standing = standing;
	}
	
	public double getFinishTime() {
		return finishTime;
	}
	
	public void setFinishTime(double finishTime) {
		this.finishTime = finishTime;
	}
	
	
	
}
