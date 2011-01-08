package ee.ignorance.transformiceapi.protocol.client;

import ee.ignorance.transformiceapi.protocol.ByteBuffer;
import ee.ignorance.transformiceapi.util.HashUtils;

public class RegisterRequest extends AbstractClientRequest {

	private String username;
	private String password;
	
	public RegisterRequest(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	@Override
	public char[] getBytes() {
		ByteBuffer bf = new ByteBuffer();
		bf.write(0x1a);
		bf.write(0x03);
		bf.write(0x01);
		bf.print(username);
		bf.write(0x01);
		bf.print(HashUtils.SHA256(password));
		bf.write(0x00);
		return bf.getBytesChar();
	}

}
