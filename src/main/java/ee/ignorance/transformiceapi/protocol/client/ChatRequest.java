package ee.ignorance.transformiceapi.protocol.client;

import ee.ignorance.transformiceapi.protocol.ByteBuffer;

public class ChatRequest extends AbstractClientRequest {

	private String message;
	
	public ChatRequest(String message) {
		this.message = message;
	}
	
	@Override
	public char[] getBytes() {
		ByteBuffer bf = new ByteBuffer();
		bf.write(0x06);
		bf.write(0x06);
		bf.write(0x01);
		bf.print(message);
		return bf.getBytesChar();
	}

}
