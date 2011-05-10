package ee.ignorance.transformiceapi.protocol.client;

import ee.ignorance.transformiceapi.protocol.ByteBuffer;
import ee.ignorance.transformiceapi.titles.TribeRank;

public class TribeChangeRankRequest extends AbstractClientRequest {

	private String playerName;
	private int code;
	
	public TribeChangeRankRequest(String playerName, TribeRank rank) {
		this.playerName = playerName;
		this.code = TribeRank.getCode(rank);
	}

	@Override
	public byte[] getBytes() {
		ByteBuffer bf = new ByteBuffer();
		bf.write(0x10);
		bf.write(0x16);
		bf.write(0x01);
		bf.print(playerName);
		bf.write(0x01);
        bf.write(code);
        return bf.getBytes();
	}

}
