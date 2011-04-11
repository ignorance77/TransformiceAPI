package ee.ignorance.transformiceapi.event;

public class PrivateChatEvent implements Event<PrivateChatListener> {

        private String sender;
        private String message;

        public PrivateChatEvent(String sender, String message) {
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
        public void notifyListener(PrivateChatListener listener) {
                listener.privateChatReceived(sender, message);
        }

        
}
