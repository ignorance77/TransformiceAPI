package ee.ignorance.transformiceapi.event;


public class SyncChangedEvent implements Event{
    
    private String syncName;

    public SyncChangedEvent(String syncName){
        setSyncName(syncName);
    }

    public String getSyncName(){
        return syncName;
    }

    public void setSyncName(String syncName){
        this.syncName = syncName;
    }

}
