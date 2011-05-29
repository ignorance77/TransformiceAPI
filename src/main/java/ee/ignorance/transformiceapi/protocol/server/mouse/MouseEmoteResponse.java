package ee.ignorance.transformiceapi.protocol.server.mouse;

import java.util.List;

import ee.ignorance.transformiceapi.Mouse;
import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.processors.mouse.MouseEmoteProcessor;
import ee.ignorance.transformiceapi.protocol.server.Processable;

public final class MouseEmoteResponse implements Processable {

        private int mouseID;
        private Mouse.Emote emote;

        public MouseEmoteResponse(List<String> rawMessage) {
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
