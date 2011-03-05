package ee.ignorance.transformiceapi;

import ee.ignorance.transformiceapi.titles.Titles;

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
}
