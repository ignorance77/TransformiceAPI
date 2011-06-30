package ee.ignorance.transformiceapi.event;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public final class EventService {
        private final Map<Class<?>, List<?>> map = new HashMap<Class<?>, List<?>>(25);

        public <L> void add(Class<? extends Event<L>> evtClass, L listener) {
                final List<L> listeners = listenersOf(evtClass);
                if (!listeners.contains(listener)) {
                        listeners.add(listener);
                }
        }

        public <L> void remove(Class<? extends Event<L>> evtClass, L listener) {
                final List<L> listeners = listenersOf(evtClass);
                listeners.remove(listener);
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

        private <L> List<L> listenersOf(Class<? extends Event<L>> evtClass) {
                synchronized (map) {
                        @SuppressWarnings("unchecked")
                        final List<L> existing = (List<L>) map.get(evtClass);
                        if (existing != null) {
                                return existing;
                        }

                        final List<L> emptyList = new CopyOnWriteArrayList<L>();
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
