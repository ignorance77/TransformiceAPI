package ee.ignorance.transformiceapi.event;

public class RoundStartEvent implements Event<RoundStartListener> {

        @Override
        public void notifyListener(RoundStartListener listener) {
                listener.roundStarted();
        }
}
