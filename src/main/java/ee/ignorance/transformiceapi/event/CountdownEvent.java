package ee.ignorance.transformiceapi.event;

public class CountdownEvent implements Event<CountdownListener> {

	@Override
	public void notifyListener(CountdownListener listener) {
		listener.countdownStarted();
	}
}
