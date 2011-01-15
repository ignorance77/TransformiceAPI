package ee.ignorance.transformiceapi.event;


public abstract class TribePlayerConnectListener implements EventListener {

    @Override
    public boolean matches(Event e) {
        return e instanceof TribePlayerConnectEvent;
    }

}
