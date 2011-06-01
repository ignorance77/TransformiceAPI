package ee.ignorance.transformiceapi.event;

import ee.ignorance.transformiceapi.Mouse;

public class ShamanChangeEvent implements Event<ShamanChangeListener> {

        private Mouse firstShaman;
        private Mouse secondShaman;
        private boolean twoShamans;

        public boolean isTwoShamans() {
                return twoShamans;
        }

        public ShamanChangeEvent(Mouse first, Mouse second, boolean twoShamans) {
                this.firstShaman = first;
                this.secondShaman = second;
                this.twoShamans = twoShamans;
        }

        public Mouse getFirstShaman() {
                return firstShaman;
        }

        public Mouse getSecondShaman() {
                return secondShaman;
        }

        @Override
        public void notifyListener(ShamanChangeListener listener) {
                if (!twoShamans) {
                        listener.shamanChanged(firstShaman);
                } else {
                        listener.shamansChanged(firstShaman, secondShaman);
                }
        }
}
