package ee.ignorance.transformiceapi.protocol.server;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;


public class PrivateChatResponse extends AbstractResponse{

    private String sender;
    private String message;
    private int type;

    public PrivateChatResponse(byte[] rawMessage) {
        super(rawMessage);
    }

    @Override
    public void parse(byte[] rawMessage) {
        DataInputStream in = new DataInputStream(new ByteArrayInputStream(rawMessage));
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

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

}
