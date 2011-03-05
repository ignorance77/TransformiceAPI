package ee.ignorance.transformiceapi.protocol.server;

import ee.ignorance.transformiceapi.TribePlayer;
import ee.ignorance.transformiceapi.titles.TribeRank;

import java.util.ArrayList;
import java.util.List;

public class TribeListResponse extends AbstractResponse{

    private List<TribePlayer> tribePlayers;

    public TribeListResponse(List<String> rawMessage) {
        super(rawMessage);
    }

    @Override
    public void parse(List<String> rawMessage) {
        tribePlayers = new ArrayList<TribePlayer>();
        for (int i = 1; i < rawMessage.size(); i++) {
            String line = rawMessage.get(i);

            char splitter = (char)2;
            String split[] = line.split(splitter+"");

            String name = split[0];
            TribeRank rank = TribeRank.getRank(Integer.valueOf(split[1]));
            String room = split[4];

            tribePlayers.add(new TribePlayer(name, rank, room));

        }
    }

    public void setTribePlayers(List<TribePlayer> tribePlayers) {
        this.tribePlayers = tribePlayers;
    }
    public List<TribePlayer> getTribePlayers() {
        return tribePlayers;
    }
}
