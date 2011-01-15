package ee.ignorance.transformiceapi.event;


public abstract class MouseDeathListener implements EventListener{

    @Override
    public boolean matches(Event e) {
        return e instanceof MouseDeathEvent;
    }

}
