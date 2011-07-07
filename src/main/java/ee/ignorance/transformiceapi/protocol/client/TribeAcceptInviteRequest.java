package ee.ignorance.transformiceapi.protocol.client;

import ee.ignorance.transformiceapi.protocol.ByteBuffer;

public final class TribeAcceptInviteRequest implements StringMessageRequest {

	private int tribeId; // Not sure what is it

	public TribeAcceptInviteRequest(int tribeId) {
		this.tribeId = tribeId;
	}

	@Override
	public byte[] getBytes() {
		ByteBuffer bf = new ByteBuffer();
		bf.write(0x10);
		bf.write(0x0d);
		bf.write(0x01);
		bf.print(String.valueOf(tribeId));
		return bf.getBytes();
	}
}
