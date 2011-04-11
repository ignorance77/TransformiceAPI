package ee.ignorance.transformiceapi.event;

public class ShamanStatusEvent implements Event<ShamanStatusListener> {

        @Override
        public void notifyListener(ShamanStatusListener listener) {
                listener.shamanStatusReceived();
        }
}
