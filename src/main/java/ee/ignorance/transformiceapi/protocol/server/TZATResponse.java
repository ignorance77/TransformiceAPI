package ee.ignorance.transformiceapi.protocol.server;

import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.processors.TZATResponseProcessor;

public final class TZATResponse implements Processable {

	@Override
	public AbstractProcessor getProcessor() {
		return new TZATResponseProcessor();
	}
}
