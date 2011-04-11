package ee.ignorance.transformiceapi.event;

public class RoomChatEvent implements Event<RoomChatListener>  {

        private String sender;
        private String message;

        public RoomChatEvent(String sender, String message) {
                this.sender = sender;
                this.message = message;
        }

        public String getSender() {
                return sender;
        }

        public String getMessage() {
                return message;
        }

        @Override
        public void notifyListener(RoomChatListener listener) {
                listener.roomChatReceived(sender, message);
        }
}
