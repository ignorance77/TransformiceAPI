package ee.ignorance.transformiceapi.protocol.server;

import java.util.List;


public class SyncStatusResponse extends AbstractResponse {

	private int codeSync;
	
	public SyncStatusResponse(List<String> rawMessage) {
		super(rawMessage);
	}

	@Override
	public void parse(List<String> rawMessage) {
		int codeSync = Integer.parseInt(rawMessage.get(1));
		setCodeSync(codeSync);
	}

	public int getCodeSync() {
		return codeSync;
	}

	public void setCodeSync(int codeSync) {
		this.codeSync = codeSync;
	}
	
	

}
