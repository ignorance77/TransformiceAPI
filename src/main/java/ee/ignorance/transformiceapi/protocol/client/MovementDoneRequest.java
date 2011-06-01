package ee.ignorance.transformiceapi.protocol.client;

import ee.ignorance.transformiceapi.protocol.ByteBuffer;

public final class MovementDoneRequest implements StringMessageRequest {

	@Override
	public byte[] getBytes() {
		ByteBuffer bf = new ByteBuffer();
		bf.write(0x04);
		bf.write(0x0a);
		return bf.getBytes();
	}

}
