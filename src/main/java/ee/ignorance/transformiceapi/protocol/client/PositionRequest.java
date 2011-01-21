package ee.ignorance.transformiceapi.protocol.client;

import ee.ignorance.transformiceapi.protocol.ByteBuffer;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

public class PositionRequest extends AbstractClientRequest {

	private String gameCode;
	private int posX;
	private int posY;
        private int movX;
	private int movY;
	private boolean goingLeft;
	private boolean goingRight;
	private boolean jumping;
	
	public PositionRequest(String gameCode, int posX, int posY, boolean goingLeft, boolean goingRight) {
		this(gameCode, posX, posY, 0, 0, goingLeft, goingRight, false);
	}
	
	public PositionRequest(String gameCode, int posX, int posY) {
		this(gameCode, posX, posY, 0, 0, false, false, false);
	}
	
	public PositionRequest(String gameCode, int posX, int posY, int movX, int movY,
			boolean goingLeft, boolean goingRight, boolean jumping) {
		this.gameCode = gameCode;
		this.posX = posX;
		this.posY = posY;
                this.movX = movX;
                this.movY = movY;
		this.goingLeft = goingLeft;
		this.goingRight = goingRight;
		this.jumping = jumping;
	}

	@Override
	public char[] getBytes() {
                ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
                DataOutputStream out = new DataOutputStream(byteOut);
                try {
                        out.write(4);
                        out.write(4);
                        out.writeInt(Integer.parseInt(gameCode));
                        out.writeBoolean(goingRight); // right
                        out.writeBoolean(goingLeft); // left
                        out.writeShort(posX); // x coordinates
                        out.writeShort(posY); // y coordinates
                        out.writeShort(movX); // x vector
                        out.writeShort(movY); // y vector
                        out.writeBoolean(jumping);
                        out.writeByte(0); // jumping position (?), 0 for testing
                        out.writeByte(0); // no clue what this is

                } catch (Exception e)
                {
                        e.printStackTrace();
                }

                byte[] bytes = byteOut.toByteArray();
                char[] chars = new char[bytes.length];
                for(int i=0;i<chars.length;i++)
                {
                        chars[i] = (char) bytes[i];
                }
                
		return chars;
	}

}
