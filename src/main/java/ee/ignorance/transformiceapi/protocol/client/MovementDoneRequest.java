package ee.ignorance.transformiceapi.protocol.client;

import ee.ignorance.transformiceapi.protocol.ByteBuffer;

public class MovementDoneRequest extends AbstractClientRequest {

	@Override
	public byte[] getBytes() {
		ByteBuffer bf = new ByteBuffer();
		bf.write(0x04);
		bf.write(0x0a);
		return bf.getBytes();
	}

}
