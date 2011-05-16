package ee.ignorance.transformiceapi.event;

import ee.ignorance.transformiceapi.Friend;

import java.util.List;

public interface FriendListListener {

        void friendListReceived(List<Friend> friendList);
}
