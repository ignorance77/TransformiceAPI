package ee.ignorance.transformiceapi.protocol.server;

import java.util.List;

import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.processors.TribePlayerProcessor;
import ee.ignorance.transformiceapi.titles.TribeRank;

public final  class TribePlayerResponse implements Processable {

        private String playerName;
        private TribeRank rank;
        private int type;

        public TribePlayerResponse(List<String> rawMessage) {
				if (rawMessage.size() > 1) {
						type = Integer.parseInt(rawMessage.get(1));
				}
				if (rawMessage.size() > 2) {
						playerName = rawMessage.get(2);
				}
				if (getType() == 12) { // Not sure if it's good to place it here
						rank = TribeRank.getRank(Integer.parseInt(rawMessage.get(3)));
				}
        }

        public String getPlayerName() {
                return playerName;
        }

        public TribeRank getRank() {
                return rank;
        }

        public int getType() {
                return type;
        }

        @Override
        public AbstractProcessor getProcessor() {
                return new TribePlayerProcessor();
        }
}
