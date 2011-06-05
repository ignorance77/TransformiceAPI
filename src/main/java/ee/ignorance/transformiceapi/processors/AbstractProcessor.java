package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.protocol.server.Processable;

public abstract class AbstractProcessor<T extends Processable> {

         public abstract void process(T response, GameConnection connection);
}
