package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;

public abstract class AbstractProcessor {

        public abstract void process(AbstractResponse response, GameConnection connection);
}
