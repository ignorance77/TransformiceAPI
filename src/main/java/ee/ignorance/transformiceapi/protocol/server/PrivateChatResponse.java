package ee.ignorance.transformiceapi.protocol.server;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.util.List;


public class PrivateChatResponse extends AbstractResponse{

    private String sender;
    private String message;
    private int type;

    public PrivateChatResponse(List<String> rawMessage) {
        super(rawMessage);
    }

    @Override
    public void parse(List<String> rawMessage) {
        DataInputStream in = new DataInputStream(new ByteArrayInputStream(rawMessage.get(0).getBytes()));
        try {
                setType(in.readByte());
                setSender(in.readUTF());
                setMessage(in.readUTF());
        } catch (Exception e) {
                e.printStackTrace();
        }
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public String getMessage() {
        return message;
    }

    public String setType(int type) {
        return sender;
    }

    public int getType() {
        return type;
    }

}
