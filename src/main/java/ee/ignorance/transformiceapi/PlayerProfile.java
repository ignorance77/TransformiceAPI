package ee.ignorance.transformiceapi;

import java.util.List;

import ee.ignorance.transformiceapi.titles.Title;
import ee.ignorance.transformiceapi.titles.Titles;

public class PlayerProfile {

        private String playerName;
        
        private int saves;
        private int hardSaves;
        private int personalGathered;
        private int firsts;
        private int cheese;
        
        private int titleNumber;
        
        private List<Integer> unlockedTitles;
        
        private String avatarId;
        
        private String tribe;

        public PlayerProfile(String playerName, int saves, int hardSaves, int personalGathered, int firsts, int cheese, 
        						int titleNumber, List<Integer> unlockedTitles, String avatarId, String tribe) {
                this.playerName = playerName;
                
                this.saves = saves;
                this.hardSaves = hardSaves;
                this.personalGathered = personalGathered;
                this.firsts = firsts;
                this.cheese = cheese;
                
                this.titleNumber = titleNumber;
                this.unlockedTitles = unlockedTitles;
                this.avatarId = avatarId;
                this.tribe = tribe;
        }

        public String getPlayer() {
                return playerName;
        }

        public void setPlayer(String playerName) {
                this.playerName = playerName;
        }

        public int getSaves() {
                return saves;
        }

        public void setSaves(int saves) {
                this.saves = saves;
        }

        public int getHardSaves() {
                return hardSaves;
        }

        public void setHardSaves(int hardSaves) {
                this.hardSaves = hardSaves;
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

        public int getTitleNumber() {
        	return titleNumber;
        }
        public void setTitleNumber(int titleNumber) {
        	this.titleNumber = titleNumber;
        }
        
        public List<Integer> getUnlockedTitles() {
        	return unlockedTitles;
        }
        public void setUnlockedTitles(List<Integer> unlockedTitles) {
        	this.unlockedTitles = unlockedTitles;
        }
        
        public String getAvatarId() {
        	return avatarId;
        }
        public void setAvatarId(String avatarId) {
        	this.avatarId = avatarId;
        }
        
        public String getTribe() {
            return tribe;
	    }
	
	    public void setTribe(String tribe) {
	            this.tribe = tribe;
	    }

        /* all nextTitle methods return null if no title is found */
        public Title nextCheeseTitle() {
                return Titles.nextCheeseTitle(cheese);
        }

        public Title nextFirstsTitle() {
                return Titles.nextFirstsTitle(firsts);
        }

        public Title nextSavesTitle() {
                return Titles.nextSavesTitle(saves);
        }

        public Title nextHardSavesTitle() {
                return Titles.nextHardSavesTitle(hardSaves);
        }

        @Override
        public String toString() {
                return "PlayerProfile [playerName=" + playerName + ", titleNumber = "+titleNumber
                		+ ", saves=" + saves + ", hardSaves=" + hardSaves + ", personalGathered=" + personalGathered
                		+ ", first=" + firsts + ", cheese=" + cheese 
                		+ ", unlockedTitles = ("+unlockedTitles.size()+" titles)" + ", avatarId = "+avatarId
                        + ", tribe=" + tribe +"]";
        }
}
