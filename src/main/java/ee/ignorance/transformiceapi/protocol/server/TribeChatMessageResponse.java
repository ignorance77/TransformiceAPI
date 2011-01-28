package ee.ignorance.transformiceapi.protocol.server;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;


public class TribeChatMessageResponse extends AbstractResponse{

    private String sender;
    private String message;

    public TribeChatMessageResponse(byte[] rawMessage) {
        super(rawMessage);
    }

    @Override
    public void parse(byte[] rawMessage) {
        DataInputStream in = new DataInputStream(new ByteArrayInputStream(rawMessage));
        try {
                setMessage(in.readUTF());
                setSender(in.readUTF());
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

}
