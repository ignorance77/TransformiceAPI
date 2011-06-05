package ee.ignorance.transformiceapi.protocol.server;

import java.util.List;

import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.processors.UrlProcessor;

public final class UrlResponse implements Processable {

        private int CMDTEC;
        private int[] MDT;

        public UrlResponse(List<String> rawMessage) {
        	   MDT = new int[10];
               String MDTString = rawMessage.get(2);
               for (int i = 0; i < 10; i++) {
                       int c = MDTString.charAt(i) - '0';
                       if (c == 0) {
                               MDT[i] = 10;
                       } else {
                               MDT[i] = c;
                       }
               }

               CMDTEC = Integer.parseInt(rawMessage.get(3));
        }

        public Integer getCMDTEC() {
                return CMDTEC;
        }

        public int[] getMDT() {
                return MDT;
        }

        @Override
        public AbstractProcessor getProcessor() {
                return new UrlProcessor();
        }
}
