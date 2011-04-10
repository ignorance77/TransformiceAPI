package ee.ignorance.transformiceapi.protocol.server;

import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.processors.TribePlayerProcessor;

import java.util.List;

public class TribePlayerResponse extends AbstractResponse {

        private String playerName;
        private int type;

        public TribePlayerResponse(List<String> rawMessage) {
                super(rawMessage);
        }

        @Override
        public void parse(List<String> rawMessage) {
                if (rawMessage.size() > 1) {
                        type = Integer.parseInt(rawMessage.get(1));
                }
                if (rawMessage.size() > 2) {
                        playerName = rawMessage.get(2);
                }
        }

        public String getPlayerName() {
                return playerName;
        }

        public int getType() {
                return type;
        }

        @Override
        public AbstractProcessor getProcessor() {
                return new TribePlayerProcessor();
        }
}
