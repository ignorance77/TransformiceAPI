package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;

public abstract class AbstractProcessor<T extends AbstractResponse> {

         public abstract void process(T response, GameConnection connection);
}
