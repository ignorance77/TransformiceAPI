package ee.ignorance.transformiceapi.protocol.server;

import java.util.ArrayList;
import java.util.List;

import ee.ignorance.transformiceapi.TribePlayer;
import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.processors.TribeListProcessor;
import ee.ignorance.transformiceapi.titles.TribeRank;

public final class TribeListResponse implements Processable {

	private final static String separator = String.valueOf((char) 0x02);
	
	private List<TribePlayer> tribePlayers;

	public TribeListResponse(List<String> rawMessage) {
		tribePlayers = new ArrayList<TribePlayer>();
				
		for (int i = 1; i < rawMessage.size(); i++) {
			String playerInfo = rawMessage.get(i);
			
			String[] data = playerInfo.split(separator);
						
			String playerName = data[0];
			TribeRank rank = TribeRank.getRank(Integer.valueOf(data[1]));
			String avatarId = data[2];
			int titleNumber = Integer.parseInt(data[3]);
			String roomName = data[4];
			
			tribePlayers.add(new TribePlayer(playerName, rank, avatarId, titleNumber, roomName));	
		}
	}

	public List<TribePlayer> getTribePlayers() {
		return tribePlayers;
	}

	@Override
	public AbstractProcessor getProcessor() {
		return new TribeListProcessor();
	}
}
