package ee.ignorance.transformiceapi.protocol.client;

import ee.ignorance.transformiceapi.Mouse;
import ee.ignorance.transformiceapi.protocol.ByteBuffer;

public final class MouseBalloonRequest extends AbstractClientRequest {
	
	Mouse mouse;
	public MouseBalloonRequest(Mouse mouse) {
		this.mouse = mouse;
	}
	
	@Override
	public byte[] getBytes() {
		ByteBuffer bf = new ByteBuffer();
		bf.write(8);
		bf.write(0x10);
		bf.write(1);
		bf.print(String.valueOf(mouse.getCode()));
		return bf.getBytes();
	}
}
