package ee.ignorance.transformiceapi.protocol.server;

import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.processors.CountdownProcessor;

public class CountdownResponse implements Processable {

	@Override
	public AbstractProcessor getProcessor() {
		return new CountdownProcessor();
	}

}
