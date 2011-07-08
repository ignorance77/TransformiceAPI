package ee.ignorance.transformiceapi.protocol.server;

import java.util.ArrayList;
import java.util.List;

import ee.ignorance.transformiceapi.PlayerProfile;
import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.processors.PlayerProfileProcessor;

public final class PlayerProfileResponse implements Processable {

        private PlayerProfile playerProfile;

        public PlayerProfileResponse(List<String> rawMessage) {
				String playerName = rawMessage.get(1);
						
				String[] statsData = rawMessage.get(2).split(",");
				int saves = Integer.parseInt(statsData[0]);
				int personalGathered = Integer.parseInt(statsData[1]);
				int firsts = Integer.parseInt(statsData[2]);
				int cheese = Integer.parseInt(statsData[3]);
				int hardSaves = Integer.parseInt(statsData[4]);
				
				int titleNumber = Integer.parseInt(rawMessage.get(3));
				
				List<Integer> unlockedTitles = new ArrayList<Integer>();
				for (String s : rawMessage.get(4).split(",")) {
				    unlockedTitles.add(Integer.valueOf(s));
				}
				
				String avatarId = rawMessage.get(5);
		
				String tribe = rawMessage.get(6);
				
				playerProfile = new PlayerProfile(playerName, saves, hardSaves, personalGathered, firsts,
						cheese, titleNumber, unlockedTitles, avatarId, tribe);
        }

        public PlayerProfile getPlayerProfile() {
                return playerProfile;
        }

        @Override
        public AbstractProcessor getProcessor() {
                return new PlayerProfileProcessor();
        }
}
