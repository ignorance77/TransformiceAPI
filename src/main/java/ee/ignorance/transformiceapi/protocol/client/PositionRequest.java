package ee.ignorance.transformiceapi.protocol.client;

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
        private byte jumpingImage;
        private byte unk;
	
	public PositionRequest(String gameCode, int posX, int posY, int movX, int movY,
			boolean goingLeft, boolean goingRight, boolean jumping, byte jumpingImage, byte unk) {
		this.gameCode = gameCode;
		this.posX = posX;
		this.posY = posY;
                this.movX = movX;
                this.movY = movY;
		this.goingLeft = goingLeft;
		this.goingRight = goingRight;
		this.jumping = jumping;
                this.jumpingImage = jumpingImage;
                this.unk = unk;
	}

	@Override
	public byte[] getBytes() {
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
                        out.writeByte(jumpingImage);
                        out.writeByte(unk); // no clue what this is

                } catch (Exception e)
                {
                        e.printStackTrace();
                }
                return byteOut.toByteArray();
	}
}
