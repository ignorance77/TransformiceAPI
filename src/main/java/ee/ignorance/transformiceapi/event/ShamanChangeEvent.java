package ee.ignorance.transformiceapi.event;

public class ShamanChangeEvent implements Event {

	private int firstCode;
	private int secondCode;
	
	public ShamanChangeEvent(int firstCode, int secondCode) {
		this.firstCode = firstCode;
		this.secondCode = secondCode;
	}

	public int getFirstCode() {
		return firstCode;
	}

	public void setFirstCode(int firstCode) {
		this.firstCode = firstCode;
	}

	public int getSecondCode() {
		return secondCode;
	}

	public void setSecondCode(int secondCode) {
		this.secondCode = secondCode;
	}
	
	
}
