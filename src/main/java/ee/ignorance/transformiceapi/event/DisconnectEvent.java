package ee.ignorance.transformiceapi.event;

public class DisconnectEvent implements Event<DisconnectListener> {

	@Override
	public void notifyListener(DisconnectListener listener) {
		listener.disconnected();

	}
}
