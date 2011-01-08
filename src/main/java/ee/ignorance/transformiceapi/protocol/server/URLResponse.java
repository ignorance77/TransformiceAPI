package ee.ignorance.transformiceapi.protocol.server;

import java.util.List;

public class URLResponse extends AbstractResponse {

	private Integer CMDTEC;
	private char[] MDT;
	
	public URLResponse(List<String> rawMessage) {
		super(rawMessage);
	}

	@Override
	public void parse(List<String> rawMessage) {
		char[] MDT = new char[10];
		String MDTString = rawMessage.get(2);
		for (int i = 0; i < 10; i++) {
			int c = MDTString.charAt(i) -'0';
			if (c == 0) {
				MDT[i] = (char)(10);
			} else {
				MDT[i] = (char)(c);
			}
		}
		setMDT(MDT);
		setCMDTEC(Integer.parseInt(rawMessage.get(3)));
		System.out.println(getCMDTEC());
	}

	public Integer getCMDTEC() {
		return CMDTEC;
	}

	public void setCMDTEC(Integer cMDTEC) {
		CMDTEC = cMDTEC;
	}

	public char[] getMDT() {
		return MDT;
	}

	public void setMDT(char[] mDT) {
		MDT = mDT;
	}
	
}
