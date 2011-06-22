package ee.ignorance.transformiceapi.protocol.client;

import ee.ignorance.transformiceapi.protocol.ByteBuffer;

public final class TribeKickRequest implements StringMessageRequest {

	private String playerName;

	public TribeKickRequest(String playerName) {
		this.playerName = playerName;
	}

	@Override
	public byte[] getBytes() {
		ByteBuffer bf = new ByteBuffer();
		bf.write(0x10);
		bf.write(0x15);
		bf.write(0x01);
		bf.print(playerName);
		return bf.getBytes();
	}

}
