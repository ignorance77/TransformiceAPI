package ee.ignorance.transformiceapi.protocol.server;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
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
				
				String titleNumber = rawMessage.get(3);
				
				List<String> unlockedTitles = Arrays.asList(rawMessage.get(4).split(","));
				
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
