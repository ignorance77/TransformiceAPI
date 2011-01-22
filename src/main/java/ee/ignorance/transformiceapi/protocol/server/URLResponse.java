package ee.ignorance.transformiceapi.protocol.server;

import java.util.List;

public class URLResponse extends AbstractResponse {

	private Integer CMDTEC;
	private int[] MDT;
	
	public URLResponse(List<String> rawMessage) {
		super(rawMessage);
	}

	@Override
	public void parse(List<String> rawMessage) {
		int[] MDT = new int[10];
		String MDTString = rawMessage.get(2);
		for (int i = 0; i < 10; i++) {
			int c = MDTString.charAt(i) - '0';
			if (c == 0) {
				MDT[i] = 10;
			} else {	
				MDT[i] = c;
			}
		}
		setMDT(MDT);
		setCMDTEC(Integer.parseInt(rawMessage.get(3).trim()));
	}

	public Integer getCMDTEC() {
		return CMDTEC;
	}

	public void setCMDTEC(Integer cMDTEC) {
		CMDTEC = cMDTEC;
	}

	public int[] getMDT() {
		return MDT;
	}

	public void setMDT(int[] mDT) {
		MDT = mDT;
	}
	
}
