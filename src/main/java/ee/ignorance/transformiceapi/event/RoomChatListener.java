package ee.ignorance.transformiceapi.event;

public interface RoomChatListener {

        void roomChatReceived(String sender, String message);
}
