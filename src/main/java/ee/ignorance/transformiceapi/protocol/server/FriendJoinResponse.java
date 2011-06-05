package ee.ignorance.transformiceapi.protocol.server;

import java.util.List;

import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.processors.FriendJoinProcessor;

public final class FriendJoinResponse implements Processable {

        private String name;

        public FriendJoinResponse(List<String> rawMessage) {
        		name = rawMessage.get(1);
        }

        public String getName() {
                return name;
        }

        @Override
        public AbstractProcessor getProcessor() {
                return new FriendJoinProcessor();
        }
}
