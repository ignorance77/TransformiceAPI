package ee.ignorance.transformiceapi.protocol.server;

import ee.ignorance.transformiceapi.PlayerProfile;
import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.processors.PlayerProfileProcessor;

import java.util.List;

public class PlayerProfileResponse extends AbstractResponse {

        private PlayerProfile playerProfile;

        public PlayerProfileResponse(List<String> rawMessage) {
                super(rawMessage);
        }

        @Override
        public void parse(List<String> rawMessage) {
                String name = rawMessage.get(1);
                String tribe = rawMessage.get(rawMessage.size() - 1);

                String[] profileData = rawMessage.get(2).split(",");
                int saves = Integer.parseInt(profileData[0]);
                int personalGathered = Integer.parseInt(profileData[1]);
                int firsts = Integer.parseInt(profileData[2]);
                int cheese = Integer.parseInt(profileData[3]);
                int hardSaves = Integer.parseInt(profileData[4]);

                playerProfile = new PlayerProfile(name, tribe, saves, hardSaves, personalGathered, firsts, cheese);
        }

        public PlayerProfile getPlayerProfile() {
                return playerProfile;
        }

        @Override
        public AbstractProcessor getProcessor() {
                return new PlayerProfileProcessor();
        }
}
