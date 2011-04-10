package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.protocol.client.TZATRequest;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;

public class TZATResponseProcessor extends AbstractProcessor {

        @Override
        public void process(AbstractResponse response, final GameConnection connection) {
                final long start = System.currentTimeMillis();
                new Thread() {

                        @Override
                        public void run() {
                                while (true) {
                                        if (System.currentTimeMillis() - start > 10000) {
                                                TZATRequest request = new TZATRequest();
                                                connection.getPlayer().getConnection().sendRequest(request);
                                                break;
                                        }
                                        try {
                                                Thread.sleep(50);
                                        } catch (InterruptedException e) {
                                        }
                                }
                        }
                }.start();
        }
}
