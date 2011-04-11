package ee.ignorance.transformiceapi.event;

public interface PrivateChatListener {

        void privateChatReceived(String sender, String message);
}
