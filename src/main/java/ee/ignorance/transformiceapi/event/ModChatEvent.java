package ee.ignorance.transformiceapi.event;

public class ModChatEvent implements Event<ModChatListener> {

        private String sender;
        private String message;

        public ModChatEvent(String sender, String message) {
                this.message = message;
                this.sender = sender;
        }

        public String getMessage() {
                return message;
        }

        public String getSender() {
                return sender;
        }

        @Override
        public void notifyListener(ModChatListener listener) {
                listener.modChatReceived(sender, message);
        }
}
