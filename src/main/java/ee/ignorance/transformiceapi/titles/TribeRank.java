package ee.ignorance.transformiceapi.titles;

public enum TribeRank {

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
        
        public static int getCode(TribeRank tribeRank) {
            if (tribeRank == Cooker) {
                    return 1;
            }
            if (tribeRank == Soldier) {
                    return 2;
            }
            if (tribeRank == Treasurer) {
                    return 3;
            }
            if (tribeRank == Recruiter) {
                    return 4;
            }
            if (tribeRank == Hunteress) {
                    return 5;
            }
            if (tribeRank == Initiated) {
                    return 6;
            }
            if (tribeRank == ShamanApprentice) {
                    return 7;
            }
            if (tribeRank == TribesShaman) {
                    return 8;
            }
            if (tribeRank == SpiritualChief) {
                    return 9;
            }

            return 0;
    }
}
