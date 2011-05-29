package ee.ignorance.transformiceapi.event;

import ee.ignorance.transformiceapi.Mouse;

public class SyncChangeEvent implements Event<SyncChangeListener> {

        private Mouse sync;

        public SyncChangeEvent(Mouse sync) {
                this.sync = sync;
        }

       
        @Override
        public void notifyListener(SyncChangeListener listener) {
                listener.syncChanged(sync);
        }
}
