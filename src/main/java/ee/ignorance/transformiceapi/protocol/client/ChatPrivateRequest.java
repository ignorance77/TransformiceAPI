package ee.ignorance.transformiceapi.protocol.client;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

public class ChatPrivateRequest extends AbstractClientRequest {

	private String message;
        private String recipient;

	public ChatPrivateRequest(String recipient,String message ) {
		this.recipient = recipient;
                this.message = message;
	}

	@Override
	public char[] getBytes() {
            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
            DataOutputStream out = new DataOutputStream(byteOut);
            try {
                out.writeByte(6);
                out.writeByte(7);
                out.writeUTF(recipient);
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
