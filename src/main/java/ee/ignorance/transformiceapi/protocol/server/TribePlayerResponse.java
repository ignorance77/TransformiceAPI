package ee.ignorance.transformiceapi.protocol.server;

import java.util.List;


public class TribePlayerResponse extends AbstractResponse{
    
    private String playerName;
    private int type;

    public TribePlayerResponse(List<String> rawMessage) {
        super(rawMessage);
    }

    @Override
    public void parse(List<String> rawMessage) {
        if(rawMessage.size()>1)
        {
            setType(Integer.parseInt(rawMessage.get(1)));
        }
        if(rawMessage.size()>2)
        {
            setPlayerName(rawMessage.get(2));
        }
    }

    public void setPlayerName(String playerName){
        this.playerName = playerName;
    }

    public String getPlayerName(){
        return playerName;
    }

    public void setType(int type){
        this.type = type;
    }

    public int getType(){
        return type;
    }

}
