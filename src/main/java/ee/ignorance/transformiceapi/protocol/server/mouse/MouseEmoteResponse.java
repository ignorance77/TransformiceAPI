package ee.ignorance.transformiceapi.protocol.server.mouse;

import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.processors.mouse.MouseEmoteProcessor;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;

import java.util.List;

public class MouseEmoteResponse extends AbstractResponse {

        private int mouseID;
        private int emote;

        public MouseEmoteResponse(List<String> rawMessage) {
                super(rawMessage);
        }

        @Override
        public void parse(List<String> rawMessage) {
                mouseID = Integer.valueOf(rawMessage.get(1));
                emote = Integer.valueOf(rawMessage.get(2));
        }

        public int getMouseID() {
                return mouseID;
        }

        public int getEmote() {
                return emote;
        }

        @Override
        public AbstractProcessor getProcessor() {
                return new MouseEmoteProcessor();
        }
}
