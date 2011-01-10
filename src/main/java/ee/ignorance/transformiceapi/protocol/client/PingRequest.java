package ee.ignorance.transformiceapi.protocol.client;

import ee.ignorance.transformiceapi.protocol.ByteBuffer;

public class PingRequest extends AbstractClientRequest {

	private long lastPingTime;
	
	public PingRequest(long lastPingTime) {
		this.lastPingTime = lastPingTime;
	}
	
	@Override
	public char[] getBytes() {
		ByteBuffer bf = new ByteBuffer();
		bf.write(0x1a);
		bf.write(0x02);
		bf.write(0x01);
//		bf.print("" + (System.currentTimeMillis() - lastPingTime));
		bf.print("10500");
		return bf.getBytesChar();
	}

}
