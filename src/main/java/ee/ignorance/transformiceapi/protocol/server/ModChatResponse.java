package ee.ignorance.transformiceapi.protocol.server;

import java.util.List;

public class ModChatResponse extends AbstractResponse{

    private String message;

    public ModChatResponse(List<String> rawMessage) {
        super(rawMessage);
    }

    @Override
    public void parse(List<String> rawMessage) {
        setMessage(rawMessage.get(2));
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
