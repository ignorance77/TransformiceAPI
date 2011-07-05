package ee.ignorance.transformiceapi.protocol.server.mouse;

import java.io.DataInputStream;
import java.io.IOException;

import ee.ignorance.transformiceapi.Mouse;
import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.processors.mouse.MouseEmoteProcessor;
import ee.ignorance.transformiceapi.protocol.server.Processable;

public final class MouseEmoteResponse implements Processable {

        private int mouseID;
        private Mouse.Emote emote;

        public MouseEmoteResponse(DataInputStream in) throws IOException {
	            mouseID = in.readInt();
	            emote = Mouse.Emote.getEmote(in.readByte());				
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
