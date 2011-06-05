package ee.ignorance.transformiceapi.event;

import java.util.ArrayList;
import java.util.HashMap;

public final class EventService {

        private final HashMap<Class, ArrayList> map = new HashMap<Class, ArrayList>(25);

        public <L> void add(Class<? extends Event<L>> evtClass, L listener) {
                final ArrayList<L> listeners = listenersOf(evtClass);
                synchronized (listeners) {
                        if (!listeners.contains(listener)) {
                                listeners.add(listener);
                        }
                }
        }

        public <L> void remove(Class<? extends Event<L>> evtClass, L listener) {
                final ArrayList<L> listeners = listenersOf(evtClass);
                synchronized (listeners) {
                        listeners.remove(listener);
                }
        }
        
        public void remove(Class<? extends Event<?>> eventClass) {
        	synchronized (map) {
				map.remove(eventClass);
			}
        }
        
        public void removeAll() {
        	synchronized (map) {
        		map.clear();
			}
        }

        private <L> ArrayList<L> listenersOf(Class<? extends Event<L>> evtClass) {
                synchronized (map) {
                        @SuppressWarnings("unchecked")
                        final ArrayList<L> existing = map.get(evtClass);
                        if (existing != null) {
                                return existing;
                        }

                        final ArrayList<L> emptyList = new ArrayList<L>(5);
                        map.put(evtClass, emptyList);
                        return emptyList;
                }
        }

        public <L> void notify(final Event<L> evt) {
                @SuppressWarnings("unchecked")
                Class<Event<L>> evtClass = (Class<Event<L>>) evt.getClass();

                for (L listener : listenersOf(evtClass)) {
                        evt.notifyListener(listener);
                }
        }
}
