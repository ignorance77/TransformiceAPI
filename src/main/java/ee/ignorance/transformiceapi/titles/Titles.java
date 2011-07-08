package ee.ignorance.transformiceapi.titles;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Titles {
    private static final Map<Integer, Title> titles = new HashMap<Integer, Title>();
    private static final SortedMap<Integer, Title> firstsTitles = new TreeMap<Integer, Title>();
    private static final SortedMap<Integer, Title> cheeseTitles = new TreeMap<Integer, Title>();
    private static final SortedMap<Integer, Title> savesTitles = new TreeMap<Integer, Title>();
    private static final SortedMap<Integer, Title> hardSavesTitles = new TreeMap<Integer, Title>();

    static {
        load();
    }

    public static Title getTitle(int titleId) {
        return titles.get(titleId);
    }
    
    public static Title nextCheeseTitle(int cheeseCount) {
        return nextTitle(cheeseCount, cheeseTitles);
    }
    
    public static Title nextFirstsTitle(int firstsCount) {
        return nextTitle(firstsCount, firstsTitles);
    }
    
    public static Title nextSavesTitle(int savesCount) {
        return nextTitle(savesCount, savesTitles);
    }
    
    public static Title nextHardSavesTitle(int hardSavesCount) {
        return nextTitle(hardSavesCount, hardSavesTitles);
    }
    
    public static Map<Integer, Title> getAllTitles() {
        return titles;
    }

    public static SortedMap<Integer, Title> getCheeseTitles() {
        return cheeseTitles;
    }

    public static SortedMap<Integer, Title> getFirstsTitles() {
        return firstsTitles;
    }

    public static SortedMap<Integer, Title> getSavesTitles() {
        return savesTitles;
    }

    public static SortedMap<Integer, Title> getHardSavesTitles() {
        return hardSavesTitles;
    }

    private static int nextCount(int currentCount, SortedMap<Integer, Title> map) {
        SortedMap<Integer, Title> tail = map.tailMap(currentCount);
        if (!tail.isEmpty()) {
            return tail.firstKey();
        } else {
            return -1;
        }
    }

    private static Title nextTitle(int currentCount, SortedMap<Integer, Title> map) {
        return map.get(nextCount(currentCount + 1, map));
    }

    private static void load() {
        titles.putAll(TitleReader.read());
        for (Title t : titles.values()) {
            switch (t.getType()) {
            case CheeseGathered:
                cheeseTitles.put(t.getRequirement(), t);
                break;
            case FirstPlace:
                firstsTitles.put(t.getRequirement(), t);
                break;
            case ShamanSave:
                savesTitles.put(t.getRequirement(), t);
                break;
            case ShamanHardSave:
                hardSavesTitles.put(t.getRequirement(), t);
                break;
            }
        }
    }
}
