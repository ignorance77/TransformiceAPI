package ee.ignorance.transformiceapi.event;

public interface Event<L> {

        void notifyListener(L listener);
}
