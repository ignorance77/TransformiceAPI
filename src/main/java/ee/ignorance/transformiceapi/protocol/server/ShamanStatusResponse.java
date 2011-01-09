package ee.ignorance.transformiceapi.protocol.server;

import java.util.List;

public class ShamanStatusResponse extends AbstractResponse{

	private int shamanCode;
	private int secondShamanCode;
	private boolean isTwoShamans;
	
	public ShamanStatusResponse(List<String> rawMessage) {
		super(rawMessage);
	}

	@Override
	public void parse(List<String> rawMessage) {
                if(rawMessage.size() == 1){ //Map without shaman
                    setShamanCode(0);
                    return;
                }
		setShamanCode(Integer.parseInt(rawMessage.get(1)));
		if (rawMessage.size() > 2) {
			setTwoShamans(true);
			setSecondShamanCode(Integer.parseInt(rawMessage.get(2)));
		}
	}

	public int getShamanCode() {
		return shamanCode;
	}

	public void setShamanCode(int shamanCode) {
		this.shamanCode = shamanCode;
	}

	public int getSecondShamanCode() {
		return secondShamanCode;
	}

	public void setSecondShamanCode(int secondShamanCode) {
		this.secondShamanCode = secondShamanCode;
	}

	public boolean isTwoShamans() {
		return isTwoShamans;
	}

	public void setTwoShamans(boolean isTwoShamans) {
		this.isTwoShamans = isTwoShamans;
	}

	
}
