package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.UrlResponse;

public class UrlProcessor  extends AbstractProcessor {

        @Override
        public void process(AbstractResponse response, GameConnection connection) {
                UrlResponse resp = (UrlResponse) response;
                connection.setUrlSent(true);
               	connection.setPrefix(resp.getMDT(), resp.getCMDTEC());
        }

}