package ee.ignorance.transformiceapi.protocol.client;

import ee.ignorance.transformiceapi.protocol.ByteBuffer;

public class PositionRequest extends AbstractClientRequest {

	private String gameCode;
	private int posX;
	private int posY;
	
	public PositionRequest(String gameCode, int posX, int posY) {
		this.gameCode = gameCode;
		this.posX = posX;
		this.posY = posY;
	}
	
	@Override
	public char[] getBytes() {
		ByteBuffer bf = new ByteBuffer();
		bf.write(0x04);
		bf.write(0x04);
		bf.write(0x01);
		bf.print(gameCode);
		bf.write(0x01);
		bf.print("0");
		bf.write(0x01);
		bf.print("0");
		bf.write(0x01);
		bf.print("" + posX);
		bf.write(0x01);
		bf.print("" + posY);
		bf.write(0x01);
		bf.print("0");
		bf.write(0x01);
		bf.print("0");
		bf.write(0x01);
		bf.print("0");
		bf.write(0x01);
		bf.print("0");
		bf.write(0x01);
		bf.print("0");
		return bf.getBytesChar();
	}

}
