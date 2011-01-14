package ee.ignorance.transformiceapi.event;


public abstract class TribePlayerJoinListener implements EventListener {

    @Override
    public boolean matches(Event e) {
        return e instanceof TribePlayerJoinEvent;
    }
}
