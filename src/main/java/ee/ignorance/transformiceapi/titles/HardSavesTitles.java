package ee.ignorance.transformiceapi.titles;

import java.util.SortedMap;
import java.util.TreeMap;

class HardSavesTitles {

        static final SortedMap<Integer, String> hardSavesTitles;

        static {
                hardSavesTitles = new TreeMap<Integer, String>();

                hardSavesTitles.put(500, "Decorator");
                hardSavesTitles.put(2000, "Builder");
                hardSavesTitles.put(4000, "Manufacturer");
                hardSavesTitles.put(8000, "Technician");
                hardSavesTitles.put(12000, "Mechanic ");
                hardSavesTitles.put(16000, "Specialist");
                hardSavesTitles.put(20000, "Inventor");
                hardSavesTitles.put(25000, "Engineer");
                hardSavesTitles.put(30000, "Inventive Mouse");
                hardSavesTitles.put(40000, "Ingenious Mouse");
                hardSavesTitles.put(50000, "Virtuoso");


        }
}
