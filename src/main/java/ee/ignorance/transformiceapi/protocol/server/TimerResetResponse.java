package ee.ignorance.transformiceapi.protocol.server;

import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.processors.TimerResetProcessor;

public class TimerResetResponse implements Processable {

	@Override
	public AbstractProcessor getProcessor() {
		return new TimerResetProcessor();
	}

}
