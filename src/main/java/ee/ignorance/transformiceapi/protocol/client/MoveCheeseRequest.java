package ee.ignorance.transformiceapi.protocol.client;

import ee.ignorance.transformiceapi.protocol.ByteBuffer;

public final class MoveCheeseRequest implements StringMessageRequest {

	private int x;
	private int y;
	
	public MoveCheeseRequest(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public byte[] getBytes() {
		ByteBuffer bf = new ByteBuffer();
		bf.write(5);
		bf.write(16);
		bf.write(1);
		bf.print(String.valueOf(x));
		bf.write(1);
		bf.print(String.valueOf(y));
		
		return bf.getBytes();
	}
}
