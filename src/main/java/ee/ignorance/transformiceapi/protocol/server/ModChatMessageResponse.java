package ee.ignorance.transformiceapi.protocol.server;

import java.util.List;

public class ModChatMessageResponse extends AbstractResponse{

    private String message;
    private String sender;

    public ModChatMessageResponse(List<String> rawMessage) {
        super(rawMessage);
    }

    @Override
    public void parse(List<String> rawMessage) {
        setSender(rawMessage.get(1));
        setMessage(rawMessage.get(2));
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSender() {
        return sender;
    }

}
