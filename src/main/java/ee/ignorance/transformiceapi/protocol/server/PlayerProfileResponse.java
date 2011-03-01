package ee.ignorance.transformiceapi.protocol.server;

import ee.ignorance.transformiceapi.PlayerProfile;

import java.util.List;

public class PlayerProfileResponse extends AbstractResponse{

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

	setPlayerProfile(new PlayerProfile(name, tribe, saves, personalGathered, firsts, cheese));
    }

    public void setPlayerProfile(PlayerProfile player) {
        this.playerProfile = player;
    }

    public PlayerProfile getPlayerProfile() {
        return playerProfile;
    }

}
