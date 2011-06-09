package ee.ignorance.transformiceapi.titles;

import java.util.Map;
import java.util.SortedMap;

public class Titles {

        private static final SortedMap<Integer, String> firstsTitles = FirstsTitles.firstsTitles;
        private static final SortedMap<Integer, String> cheeseTitles = CheeseTitles.cheeseTitles;
        private static final SortedMap<Integer, String> savesTitles = SavesTitles.savesTitles;
        private static final SortedMap<Integer, String> hardSavesTitles = HardSavesTitles.hardSavesTitles;

        public static int cheeseForNextCheeseTitle(int currentCount) {
                return nextCount(currentCount, cheeseTitles);
        }

        public static int firstsForNextFirstsTitle(int currentCount) {
                return nextCount(currentCount, firstsTitles);
        }

        public static int savesForNextSavesTitle(int currentCount) {
                return nextCount(currentCount, savesTitles);
        }

        public static int hardSavesForNextHardSavesTitle(int currentCount) {
                return nextCount(currentCount, hardSavesTitles);
        }

        public static String nextCheeseTitle(int currentCount) {
                return nextTitle(currentCount, cheeseTitles);
        }

        public static String nextFirstsTitle(int currentCount) {
                return nextTitle(currentCount, firstsTitles);
        }

        public static String nextSavesTitle(int currentCount) {
                return nextTitle(currentCount, savesTitles);
        }

        public static String nextHardSavesTitle(int currentCount) {
                return nextTitle(currentCount, hardSavesTitles);
        }

        public static SortedMap<Integer, String> getCheeseTitles() {
                return cheeseTitles;
        }

        public static SortedMap<Integer, String> getFirstsTitles() {
                return firstsTitles;
        }

        public static SortedMap<Integer, String> getSavesTitles() {
                return savesTitles;
        }

        public static SortedMap<Integer, String> getHardSavesTitles() {
                return hardSavesTitles;
        }

        private static int nextCount(int currentCount, SortedMap<Integer, String> map) {
                return map.tailMap(currentCount).firstKey();
        }

        private static String nextTitle(int currentCount, SortedMap<Integer, String> map) {
                return AllTitles.get(map.get(nextCount(currentCount, map)));
        }
              
        public static int firstsNeededForTitle(String titleNumber) {
        	return getNeededCountForTitle(titleNumber, firstsTitles);
        }
        public static int cheeseNeededForTitle(String titleNumber) {
        	return getNeededCountForTitle(titleNumber, cheeseTitles);
        }
        public static int savesNeededForTitle(String titleNumber) {
        	return getNeededCountForTitle(titleNumber, savesTitles);
        }
        
        public static int hardSavesNeededForTitle(String titleNumber) {
        	return getNeededCountForTitle(titleNumber, hardSavesTitles);
        }
        
        private static int getNeededCountForTitle(String titleNumber, Map<Integer, String> map) {
        	for (int neededCount : map.keySet()) {
        		if (map.get(neededCount).equals(titleNumber))
        			return neededCount;
        	}
        	return -1;
        }
}
