package ee.ignorance.transformiceapi.event;

public class TribeChatEvent implements Event<TribeChatListener> {

        private String sender;
        private String message;

        public TribeChatEvent(String sender, String message) {
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
        public void notifyListener(TribeChatListener listener) {
                listener.tribeChatReceived(sender, message);
        }
}
