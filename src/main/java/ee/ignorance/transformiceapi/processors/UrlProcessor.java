package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.protocol.server.UrlResponse;

public class UrlProcessor extends AbstractProcessor<UrlResponse> {

        @Override
        public void process(UrlResponse response, GameConnection connection) {
                connection.setIntroduceSuccessful();
                connection.setPrefix(response.getMDT(), response.getCMDTEC());
        }
}
