package ee.ignorance.transformiceapi.protocol.client;

import ee.ignorance.transformiceapi.protocol.ByteBuffer;

public final class BalloonDetachRequest implements StringMessageRequest {

	@Override
	public byte[] getBytes() {
		ByteBuffer bf = new ByteBuffer();
		bf.write(8);
		bf.write(0x11);
		return bf.getBytes();
	}
}
