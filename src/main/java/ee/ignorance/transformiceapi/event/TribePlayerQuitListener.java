package ee.ignorance.transformiceapi.event;


public abstract class TribePlayerQuitListener implements EventListener {

    @Override
    public boolean matches(Event e) {
        return e instanceof TribePlayerQuitEvent;
    }
}
