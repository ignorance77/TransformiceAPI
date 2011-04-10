package ee.ignorance.transformiceapi.protocol.server;

import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.processors.FriendJoinProcessor;

import java.util.List;

public class FriendJoinResponse extends AbstractResponse {

        private String name;

        public FriendJoinResponse(List<String> rawMessage) {
                super(rawMessage);
        }

        @Override
        public void parse(List<String> rawMessage) {
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
