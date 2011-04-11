package ee.ignorance.transformiceapi.event;

public class SyncChangeEvent implements Event<SyncChangeListener> {

        private String syncName;

        public SyncChangeEvent(String syncName) {
                this.syncName = syncName;
        }

        public String getSyncName() {
                return syncName;
        }

        @Override
        public void notifyListener(SyncChangeListener listener) {
                listener.syncChanged(syncName);
        }
}
