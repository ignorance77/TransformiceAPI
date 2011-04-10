package ee.ignorance.transformiceapi.protocol.server;

import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.processors.ShamanStatusProcessor;

import java.util.List;

public class ShamanStatusResponse extends AbstractResponse {

        private int shamanCode;
        private int secondShamanCode;
        private boolean isTwoShamans;

        public ShamanStatusResponse(List<String> rawMessage) {
                super(rawMessage);
        }

        @Override
        public void parse(List<String> rawMessage) {
                if (rawMessage.size() == 1) { //Map without shaman
                        shamanCode = 0;
                        return;
                }
                if (rawMessage.size() > 1 && !rawMessage.get(1).isEmpty()) {
                        shamanCode = Integer.parseInt(rawMessage.get(1).trim());
                }
                if (rawMessage.size() > 2 && !rawMessage.get(2).isEmpty()) {
                        isTwoShamans = true;
                        secondShamanCode = Integer.parseInt(rawMessage.get(2));
                }
        }

        public int getShamanCode() {
                return shamanCode;
        }

        public int getSecondShamanCode() {
                return secondShamanCode;
        }

        public boolean isTwoShamans() {
                return isTwoShamans;
        }

        @Override
        public AbstractProcessor getProcessor() {
                return new ShamanStatusProcessor();
        }
}
