package ee.ignorance.transformiceapi;

import java.util.SortedMap;
import java.util.TreeMap;

public class PlayerProfile {

    private String playerName;
    private String tribe;
    private int saves;
    private int personalGathered;
    private int firsts;
    private int cheese;

    public PlayerProfile(String playerName, String tribe, int saves, int personalGathered, int firsts, int cheese) {
        this.playerName = playerName;
        this.tribe = tribe;
        this.saves = saves;
        this.personalGathered = personalGathered;
        this.firsts = firsts;
        this.cheese = cheese;
    }

    public String getPlayer() {
        return playerName;
    }

    public void setPlayer(String playerName) {
        this.playerName = playerName;
    }

    public String getTribe() {
        return tribe;
    }

    public void setTribe(String tribe) {
        this.tribe = tribe;
    }

    public int getSaves() {
        return saves;
    }

    public void setSaves(int saves) {
        this.saves = saves;
    }

    public int getPersonalGathered() {
        return personalGathered;
    }

    public void setPersonalGathered(int personalGathered) {
        this.personalGathered = personalGathered;
    }

    public int getFirsts() {
        return firsts;
    }

    public void setFirsts(int firsts) {
        this.firsts = firsts;
    }

    public int getCheese() {
        return cheese;
    }

    public void setCheese(int cheese) {
        this.cheese = cheese;
    }

    /* Some interesting information about upcoming titles */

    public String nextCheeseTitle() {
        return Titles.nextCheeseTitle(cheese);
    }
    public String nextFirstsTitle() {
        return Titles.nextFirstsTitle(firsts);
    }
    public String nextSavesTitle() {
        return Titles.nextSavesTitle(saves);
    }

    public int cheeseForNextCheeseTitle() {
        return Titles.cheeseForNextCheeseTitle(cheese);
    }
    public int firstsForNextFirstsTitle() {
        return Titles.firstsForNextFirstsTitle(firsts);
    }

    public int savesForNextSavesTitle() {
        return Titles.savesForNextSavesTitle(saves);
    }

    private static class Titles {

        private static final SortedMap<Integer, String> firstsTitles;
        private static final SortedMap<Integer, String> cheeseTitles;
        private static final SortedMap<Integer, String> savesTitles;

        static {

            firstsTitles = new TreeMap<Integer, String>();


            firstsTitles.put(1, "Fast Mouse");
            firstsTitles.put(10, "Agile Mouse");
            firstsTitles.put(100, "Pirate Mouse");
            firstsTitles.put(200, "Ninja Mouse");
            firstsTitles.put(300, "Rogue Mouse");
            firstsTitles.put(400, "Looter");
            firstsTitles.put(500, "Stalker");
            firstsTitles.put(600, "Frothy Mouse");
            firstsTitles.put(700, "The Silent");
            firstsTitles.put(800, "Hawk Mouse");
            firstsTitles.put(900, "Cobra Mouse");
            firstsTitles.put(1000, "Spidermouse");
            firstsTitles.put(1100, "Quick Silver");
            firstsTitles.put(1200, "Athletic Mouse");
            firstsTitles.put(1400, "Hasty Mouse");
            firstsTitles.put(1600, "Rocket Mouse");
            firstsTitles.put(1800, "Sonic The Mouse");
            firstsTitles.put(2000, "Pingless");
            firstsTitles.put(2200, "Kamikaze");
            firstsTitles.put(2400, "Warrior Mouse");
            firstsTitles.put(2600, "Mach 1");
            firstsTitles.put(2800, "Hunter ");
            firstsTitles.put(3000, "First!");
            firstsTitles.put(3200, "Sniper");
            firstsTitles.put(3400, "Flash");
            firstsTitles.put(3600, "Supermouse");
            firstsTitles.put(3800, "Light Speed");
            firstsTitles.put(4000, "Time Traveler");
            firstsTitles.put(4500, "Fast Wind");
            firstsTitles.put(5000, "E=MouseC²");
            firstsTitles.put(5500, "Jumper");
            firstsTitles.put(6000, "The Untouchable");
            firstsTitles.put(10000, "Wall-Jumper");
            firstsTitles.put(20000, "The Wind Master");
            firstsTitles.put(40000, "LIGHTNING");

            cheeseTitles = new TreeMap<Integer, String>();

            cheeseTitles.put(0, "Little Mouse");
            cheeseTitles.put(5, "Greedy Mouse ");
            cheeseTitles.put(20, "Here ! Cheese !");
            cheeseTitles.put(100, "Yeeeeah Cheese ^^");
            cheeseTitles.put(200, "Cheeeeeese *-*");
            cheeseTitles.put(300, "Activist Mouse");
            cheeseTitles.put(400, "Unionized Mouse");
            cheeseTitles.put(500, "Mouse on Strike");
            cheeseTitles.put(600, "Glutton Mouse");
            cheeseTitles.put(700, "Gleany");
            cheeseTitles.put(800, "Plumpy Mouse");
            cheeseTitles.put(900, "Paunchy Mouse");
            cheeseTitles.put(1000, "Chubby Mouse");
            cheeseTitles.put(1100, "Fluffy Mouse");
            cheeseTitles.put(1200, "Tubby Mouse");
            cheeseTitles.put(1300, "The Chubby");
            cheeseTitles.put(1400, "The Puffy");
            cheeseTitles.put(1500, "The Cheese Initiated");
            cheeseTitles.put(1600, "The Cheese Adept");
            cheeseTitles.put(1700, "The Cheese Priest");
            cheeseTitles.put(1800, "The Reaper");
            cheeseTitles.put(2000, "Cheese Finder");
            cheeseTitles.put(2300, "Cheese Knight");
            cheeseTitles.put(2700, "Cheesegrubber");
            cheeseTitles.put(3200, "Fatty");
            cheeseTitles.put(3800, "Stout Mouse");
            cheeseTitles.put(4600, "Cheese Lover");
            cheeseTitles.put(6000, "Camembert");
            cheeseTitles.put(7000, "Pont-L'Évêque");
            cheeseTitles.put(8000, "Cheese Catcher");
            cheeseTitles.put(9001, "It's Over 9000");
            cheeseTitles.put(10000, "Collector");
            cheeseTitles.put(14000, "Cheeseleader");
            cheeseTitles.put(18000, "Cheese Thief");
            cheeseTitles.put(22000, "Cheese Creator");
            cheeseTitles.put(26000, "Cheese Pizza");
            cheeseTitles.put(30000, "Cheese Minister");
            cheeseTitles.put(34000, "Prodigy Mouse");
            cheeseTitles.put(38000, "Princess Of Transformice");
            cheeseTitles.put(42000, "Cheesoholic");
            cheeseTitles.put(46000, "The Cheesen One");
            cheeseTitles.put(50000, "Sailor Mouse");
            cheeseTitles.put(80000, "MAH CHEESE!");


            savesTitles = new TreeMap<Integer, String>();

            savesTitles.put(10, "Shaman Disciple");
            savesTitles.put(100, "Accomplished Shaman");
            savesTitles.put(1000, "Shaman");
            savesTitles.put(2000, "Shaman Master");
            savesTitles.put(3000, "Inspired Shaman");
            savesTitles.put(4000, "Shaman Champion");
            savesTitles.put(5000, "Glorious Shaman");
            savesTitles.put(6000, "Shaman Duchess");
            savesTitles.put(7000, "Shaman Princess");
            savesTitles.put(8000, "Shaman Empress");
            savesTitles.put(9000, "Legendary Shaman");
            savesTitles.put(10000, "Immortal Shaman");
            savesTitles.put(11000, "The Chosen Shaman");
            savesTitles.put(12000, "Holy Shaman");
            savesTitles.put(13000, "Shaman Oracle");
            savesTitles.put(14000, "Shaman Prophet");
            savesTitles.put(15000, "Shamarvelous");
            savesTitles.put(16000, "Ancient Shaman");
            savesTitles.put(18000, "Fearless Shaman");
            savesTitles.put(20000, "Almighty Shamane");
            savesTitles.put(22000, "Architect Shaman");
            savesTitles.put(24000, "Mademoiselle");
            savesTitles.put(26000, "Lady Shaman");
            savesTitles.put(28000, "Loved");
            savesTitles.put(30000, "Magician");
            savesTitles.put(35000, "Hero of Mice");
            savesTitles.put(40000, "Angel Shaman");
            savesTitles.put(45000, "The Creator");
            savesTitles.put(50000, "Absolute Shaman");
            savesTitles.put(55000, "Miraculous Shaman");
            savesTitles.put(60000, "Liberator");
            savesTitles.put(65000, "Troll Shaman");
            savesTitles.put(70000, "Ghost Shaman");
            savesTitles.put(75000, "Spirit");
            savesTitles.put(80000, "Demigodess Shaman");
            savesTitles.put(85000, "Last Hope");
            savesTitles.put(90000, "Redeemer");
            savesTitles.put(100000, "Goddess Shaman");
            savesTitles.put(140000, "Alpha &nbsp; Omega");

        }

        private static int nextCount(int currentCount, SortedMap<Integer, String> map) {
            return map.tailMap(currentCount).firstKey();
        }
        private static int cheeseForNextCheeseTitle(int currentCount) {
            return nextCount(currentCount, cheeseTitles);
        }
        private static int firstsForNextFirstsTitle(int currentCount) {
            return nextCount(currentCount, firstsTitles);
        }
        private static int savesForNextSavesTitle(int currentCount) {
            return nextCount(currentCount, savesTitles);
        }
        private static String nextTitle(int currentCount, SortedMap<Integer, String> map) {
            return map.get(nextCount(currentCount, map));
        }
        private static String nextCheeseTitle(int currentCount) {
            return nextTitle(currentCount, cheeseTitles);
        }
        private static String nextFirstsTitle(int currentCount) {
            return nextTitle(currentCount, firstsTitles);
        }
        private static String nextSavesTitle(int currentCount) {
            return nextTitle(currentCount, savesTitles);
        }
    }
}
