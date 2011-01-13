package ee.ignorance.transformiceapi.event;


public abstract class SyncChangedListener implements EventListener{

    @Override
    public boolean matches(Event e) {
        return e instanceof SyncChangedEvent;
    }

}
