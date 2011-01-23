package ee.ignorance.transformiceapi.protocol.client;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

public class ChatNormalRequest extends AbstractClientRequest {

	private String message;
	
	public ChatNormalRequest(String message) {
		this.message = message;
	}
	
	@Override
	public char[] getBytes() {
            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
            DataOutputStream out = new DataOutputStream(byteOut);
            try {
                out.writeByte(6);
                out.writeByte(6);
                out.writeUTF(message);

            } catch (Exception e) {
                e.printStackTrace();
            }

            byte[] bytes = byteOut.toByteArray();
            char[] chars = new char[bytes.length];
            for (int i = 0; i < chars.length; i++) {
                chars[i] = (char) bytes[i];
            }

            return chars;
	}

}
