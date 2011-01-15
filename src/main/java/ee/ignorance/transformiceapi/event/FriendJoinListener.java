package ee.ignorance.transformiceapi.event;


public abstract class FriendJoinListener implements EventListener{
    
    @Override
    public boolean matches(Event e) {
        return e instanceof FriendJoinEvent;
    }

}
