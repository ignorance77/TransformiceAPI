package ee.ignorance.transformiceapi.event;

import ee.ignorance.transformiceapi.Mouse;

public interface ShamanChangeListener {

        void shamanChanged(Mouse shaman);

        void shamansChanged(Mouse firstShaman, Mouse secondShaman);
}
