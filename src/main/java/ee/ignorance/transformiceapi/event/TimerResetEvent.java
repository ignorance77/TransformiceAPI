package ee.ignorance.transformiceapi.event;

public class TimerResetEvent implements Event<TimerResetListener> {

	@Override
	public void notifyListener(TimerResetListener listener) {
		listener.timerReset();
	}
}
