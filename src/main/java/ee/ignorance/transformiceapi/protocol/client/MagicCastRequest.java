package ee.ignorance.transformiceapi.protocol.client;

import ee.ignorance.transformiceapi.protocol.ByteBuffer;


public class MagicCastRequest extends AbstractClientRequest {

	private int x;
	private int y;
	
	private int code;
	
	public MagicCastRequest(int code, int x, int y) {
		this.x = x;
		this.y = y;
		this.code = code;
	}
	
	@Override
	public char[] getBytes() {
		ByteBuffer bf = new ByteBuffer();
		bf.write(0x05);
		bf.write(20);
		bf.write(0x01);
		bf.print("" + code);
		bf.write(0x01);
		bf.print("" + x);
		bf.write(0x01);
		bf.print("" + y);
		bf.write(0x01);
		bf.print("0");
		bf.write(0x01);
		bf.print("0");
		bf.write(0x01);
		bf.print("0");
		bf.write(0x01);
		bf.print("1");
		return bf.getBytesChar();
	}

}
