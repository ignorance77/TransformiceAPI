package ee.ignorance.transformiceapi.event;

import java.util.ArrayList;
import java.util.List;

public class EventService {

	private List<EventListener> listeners;
	
	public EventService() {
		listeners = new ArrayList<EventListener>();
	}
	
	public void registerEventListener(EventListener listener) {
		listeners.add(listener);
	}
	
	public void unregisterEventListener(EventListener listener) {
		listeners.remove(listener);
	}
	
	public synchronized void notifyListeners(Event e) {
		for (EventListener listener : listeners) {
			if (listener.matches(e)) {
				listener.actionPerformed(e);
			}
		}
	}
	
}
