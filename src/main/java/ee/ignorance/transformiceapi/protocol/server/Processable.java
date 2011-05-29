package ee.ignorance.transformiceapi.protocol.server;

import ee.ignorance.transformiceapi.processors.AbstractProcessor;

public interface Processable {

	public abstract AbstractProcessor getProcessor();
}
