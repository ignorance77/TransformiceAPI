package ee.ignorance.transformiceapi.event;

public class FriendJoinEvent implements Event<FriendJoinListener> {

        private String name;

        public FriendJoinEvent(String name) {
                this.name = name;
        }

        public String getName() {
                return name;
        }

        @Override
        public void notifyListener(FriendJoinListener listener) {
                listener.friendJoined(name);
        }
}
