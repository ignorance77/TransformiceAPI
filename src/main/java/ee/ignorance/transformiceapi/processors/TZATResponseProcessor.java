package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.protocol.client.TZATRequest;
import ee.ignorance.transformiceapi.protocol.server.TZATResponse;

public class TZATResponseProcessor extends AbstractProcessor<TZATResponse> {

        @Override
        public void process(TZATResponse response, final GameConnection connection) {
                final long start = System.currentTimeMillis();
                new Thread() {

                        @Override
                        public void run() {
                                while (true) {
                                        if (System.currentTimeMillis() - start > 10000) {
                                                TZATRequest request = new TZATRequest();
                                                connection.sendRequest(request);
                                                break;
                                        }
                                        try {
                                                Thread.sleep(250);
                                        } catch (InterruptedException e) {
                                        }
                                }
                        }
                }.start();
        }
}
