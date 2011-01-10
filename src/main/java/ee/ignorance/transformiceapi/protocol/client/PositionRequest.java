package ee.ignorance.transformiceapi.protocol.client;

import ee.ignorance.transformiceapi.protocol.ByteBuffer;

public class PositionRequest extends AbstractClientRequest {

	private String gameCode;
	private int posX;
	private int posY;
	private boolean goingLeft;
	private boolean goingRight;
	private boolean jumping;
	
	public PositionRequest(String gameCode, int posX, int posY, boolean goingLeft, boolean goingRight) {
		this(gameCode, posX, posY, goingLeft, goingRight, false);
	}
	
	public PositionRequest(String gameCode, int posX, int posY) {
		this(gameCode, posX, posY, false, false);
	}
	
	public PositionRequest(String gameCode, int posX, int posY,
			boolean goingLeft, boolean goingRight, boolean jumping) {
		this.gameCode = gameCode;
		this.posX = posX;
		this.posY = posY;
		this.goingLeft = goingLeft;
		this.goingRight = goingRight;
		this.jumping = jumping;
	}

	@Override
	public char[] getBytes() {
		ByteBuffer bf = new ByteBuffer();
		bf.write(0x04);
		bf.write(0x04);
		bf.write(0x01);
		bf.print(gameCode);
		bf.write(0x01);
		bf.print(goingLeft ? "1" : "0");
		bf.write(0x01);
		bf.print(goingRight ? "1" : "0");
		bf.write(0x01);
		bf.print("" + posX);
		bf.write(0x01);
		bf.print("" + posY);
		bf.write(0x01);
		bf.print("0");
		bf.write(0x01);
		bf.print("0");
		bf.write(0x01);
		bf.print(jumping ? "1" : "0");
		bf.write(0x01);
		bf.print("0");
		bf.write(0x01);
		bf.print("0");
		return bf.getBytesChar();
	}

}
