package ee.ignorance.transformiceapi.event;

public abstract class MusicPlayedListener implements EventListener {

        @Override
        public boolean matches(Event e) {
                return e instanceof MusicPlayedEvent;
        }
}
