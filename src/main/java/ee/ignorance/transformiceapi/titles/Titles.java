package ee.ignorance.transformiceapi.titles;

import java.util.SortedMap;

public class Titles {

        private static final SortedMap<Integer, String> firstsTitles = FirstsTitles.firstsTitles;
        private static final SortedMap<Integer, String> cheeseTitles = CheeseTitles.cheeseTitles;
        private static final SortedMap<Integer, String> savesTitles = SavesTitles.savesTitles;

        public static int cheeseForNextCheeseTitle(int currentCount) {
                return nextCount(currentCount, cheeseTitles);
        }

        public static int firstsForNextFirstsTitle(int currentCount) {
                return nextCount(currentCount, firstsTitles);
        }

        public static int savesForNextSavesTitle(int currentCount) {
                return nextCount(currentCount, savesTitles);
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

        public static SortedMap<Integer, String> getCheeseTitles() {
                return cheeseTitles;
        }

        public static SortedMap<Integer, String> getFirstsTitles() {
                return firstsTitles;
        }

        public static SortedMap<Integer, String> getSavesTitles() {
                return savesTitles;
        }

        private static int nextCount(int currentCount, SortedMap<Integer, String> map) {
                return map.tailMap(currentCount).firstKey();
        }

        private static String nextTitle(int currentCount, SortedMap<Integer, String> map) {
                return map.get(nextCount(currentCount, map));
        }
}
