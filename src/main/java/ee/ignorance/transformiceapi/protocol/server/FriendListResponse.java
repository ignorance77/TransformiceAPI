package ee.ignorance.transformiceapi.protocol.server;

import ee.ignorance.transformiceapi.Friend;
import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.processors.FriendListProcessor;

import java.util.ArrayList;
import java.util.List;

public class FriendListResponse extends AbstractResponse {

        private List<Friend> friends;

        public FriendListResponse(List<String> rawMessage) {
                super(rawMessage);
        }

        @Override
        public void parse(List<String> rawMessage) {
                friends = new ArrayList<Friend>();
                for (int i = 1; i < rawMessage.size(); i++) {
                        String line = rawMessage.get(i);

                        char splitter = (char) 2;
                        String split[] = line.split(splitter + "");

                        String name = split[0];
                        boolean online;

                        if (split.length == 1) {
                            online = false;
                        }
                        else {
                            online = true;
                        }

                        friends.add(new Friend(name, online));

                }
        }

        public List<Friend> getFriends() {
                return friends;
        }

        @Override
        public AbstractProcessor getProcessor() {
                return new FriendListProcessor();
        }
}
