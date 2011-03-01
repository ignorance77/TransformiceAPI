package ee.ignorance.transformiceapi;

public class TribePlayer {

    private String playerName;
    private TribeRank rank;
    private String roomName;

    public TribePlayer(String playerName, TribeRank rank, String roomName) {
        this.playerName = playerName;
        this.rank = rank;
        this.roomName = roomName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public TribeRank getRank() {
        return rank;
    }

    public void setRank(TribeRank rank) {
        this.rank = rank;
    }

    public static enum TribeRank {

        Stooge("Stooge"),
        Cooker("Cooker"),
        Soldier("Soldier"),
        Treasurer("Treasurer"),
        Recruiter("Recruiter"),
        Hunteress("Hunteress"),
        Initiated("Initiated"),
        ShamanApprentice("Shaman Apprentice"),
        TribesShaman("Tribe's Shaman"),
        SpiritualChief("Spiritual Chief");

        private String string;

        TribeRank(String string) {
            this.string = string;
        }

        @Override
        public String toString() {
            return string;
        }

        public static TribeRank getRank(int code) {
            if (code == 1) {
                return Cooker;
            }
            if (code == 2) {
                return Soldier;
            }
            if (code == 3) {
                return Treasurer;
            }
            if (code == 4) {
                return Recruiter;
            }
            if (code == 5) {
                return Hunteress;
            }
            if (code == 6) {
                return Initiated;
            }
            if (code == 7) {
                return ShamanApprentice;
            }
            if (code == 8) {
                return TribesShaman;
            }
            if (code == 9) {
                return SpiritualChief;
            }

            return Stooge;
        }
    }
}
