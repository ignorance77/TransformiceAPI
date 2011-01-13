package ee.ignorance.transformiceapi.event;

public class FriendJoinEvent implements Event{

    private String name;

    public FriendJoinEvent(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
