package ee.ignorance.transformiceapi.protocol.client;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
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
		ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
            DataOutputStream out = new DataOutputStream(byteOut);
            try {
                out.writeByte(5);
                out.writeByte(20);
                out.writeShort(code);
                out.writeShort(-1); //Object Identifier? Using -1 works fine 
                out.writeShort(x);
                out.writeShort(y);
                out.writeShort(0); //Rotation
                out.writeByte(0); //x Velocity
                out.writeByte(0); //Y Velocity
                out.writeByte(1); // ?
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
