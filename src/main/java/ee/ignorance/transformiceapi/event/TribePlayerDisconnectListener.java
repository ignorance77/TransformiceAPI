package ee.ignorance.transformiceapi.event;


public abstract class TribePlayerDisconnectListener implements EventListener {

    @Override
    public boolean matches(Event e) {
        return e instanceof TribePlayerDisconnectEvent;
    }

}
