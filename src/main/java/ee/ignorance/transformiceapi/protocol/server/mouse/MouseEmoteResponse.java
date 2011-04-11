package ee.ignorance.transformiceapi.protocol.server.mouse;

import ee.ignorance.transformiceapi.Mouse;
import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.processors.mouse.MouseEmoteProcessor;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;

import java.util.List;

public class MouseEmoteResponse extends AbstractResponse {

        private int mouseID;
        private Mouse.Emote emote;

        public MouseEmoteResponse(List<String> rawMessage) {
                super(rawMessage);
        }

        @Override
        public void parse(List<String> rawMessage) {
                mouseID = Integer.valueOf(rawMessage.get(1));
                emote = Mouse.Emote.getEmote(Integer.valueOf(rawMessage.get(2)));
        }

        public int getMouseID() {
                return mouseID;
        }

        public Mouse.Emote getEmote() {
                return emote;
        }

        @Override
        public AbstractProcessor getProcessor() {
                return new MouseEmoteProcessor();
        }
}
