package ee.ignorance.transformiceapi.protocol.client;

import ee.ignorance.transformiceapi.Mouse.Emote;
import ee.ignorance.transformiceapi.protocol.ByteBuffer;

public final class MouseEmoteRequest implements ByteMessageRequest {

	private Emote emote;

	public MouseEmoteRequest(Emote emote) {
		this.emote = emote;
	}

	@Override
	public byte[] getBytes() {
		ByteBuffer bf = new ByteBuffer();
		bf.write(8);
		bf.write(1);
		bf.write(emote.ordinal());
		return bf.getBytes();
	}
}
