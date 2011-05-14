package ee.ignorance.transformiceapi.event;

import ee.ignorance.transformiceapi.Friend;

import java.util.List;

public class FriendListEvent implements Event<FriendListListener> {

        private List<Friend> friends;

        public FriendListEvent(List<Friend> friends) {
                this.friends = friends;
        }

        public List<Friend> getFriends() {
                return friends;
        }

        @Override
        public void notifyListener(FriendListListener listener) {
                listener.friendListReceived(friends);
        }
}
