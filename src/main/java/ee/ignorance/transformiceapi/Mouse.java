package ee.ignorance.transformiceapi;

import ee.ignorance.transformiceapi.shop.Outfit;


public class Mouse {

	private int code;
	private String name;
	private Outfit outfit;
	private boolean dead;
	private int score;
	private int codeForum;
	private String furColor; // RRGGBB
	private String shamanTatoosColor; // RRGGBB
        private boolean hasFinished = false;
        private double finishTime = 0.0;
        private int standing = 0;

        private int posX = 0;
        private int posY = 0;
        private int movX = 0;
        private int movY = 0;
        private boolean goingLeft = false;
        private boolean goingRight = false;
        private boolean jumping = false;
        private byte jumpingImage = 0;
        private byte portalId = 0;
        private boolean balloonAttached = false;

        private Emote emote;
	
	public static Mouse parse(String[] mouseData) {
		Mouse mouse = new Mouse();
		String name = mouseData[0];
		int code = Integer.parseInt(mouseData[1]);
		int score = Integer.parseInt(mouseData[3]);
		int codeForum = Integer.parseInt(mouseData[8].trim());
		boolean dead = mouseData[2].equals("1");
		mouse.setName(name);
		mouse.setOutfit(Outfit.parse(mouseData[7]));
		mouse.setDead(dead);
		mouse.setCode(code);
		mouse.setScore(score);
		mouse.setCodeForum(codeForum);
		mouse.setFurColor(mouseData[9]);
		mouse.setShamanTatoosColor(mouseData[10]);
		return mouse;
	}

	public boolean isDead() {
		return dead;
	}

	public void setDead(boolean dead) {
		this.dead = dead;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Outfit getOutfit() {
		return outfit;
	}
	public void setOutfit(Outfit outfit) {
		this.outfit = outfit;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getCodeForum() {
		return codeForum;
	}

	public void setCodeForum(int codeForum) {
		this.codeForum = codeForum;
	}

	public String getFurColor() {
		return furColor;
	}

	public void setFurColor(String furColor) {
		this.furColor = furColor;
	}

	public String getShamanTatoosColor() {
		return shamanTatoosColor;
	}

	public void setShamanTatoosColor(String shamanTatoosColor) {
		this.shamanTatoosColor = shamanTatoosColor;
	}

        public void setPosX(int posX){
                this.posX = posX;
        }

        public int getPosX(){
                return posX;
        }

        public void setPosY(int posY){
                this.posY = posY;
        }

        public int getPosY(){
                return posY;
        }

        public void setMovX(int movX){
                this.movX = movX;
        }

        public int getMovX(){
                return movX;
        }

        public void setMovY(int movY){
                this.movY = movY;
        }

        public int getMovY(){
                return movY;
        }

        public void setGoingLeft(boolean goingLeft){
                this.goingLeft = goingLeft;
        }

        public boolean isGoingLeft(){
                return goingLeft;
        }

        public void setGoingRight(boolean goingRight){
                this.goingRight = goingRight;
        }

        public boolean isGoingRight(){
                return goingRight;
        }

        public void setJumping(boolean jumping){
                this.jumping = jumping;
        }

        public boolean isJumping(){
                return jumping;
        }
        
        public void setJumpingImage(byte jumpingImage){
                this.jumpingImage = jumpingImage;
        }

        public byte getJumpingImage(){
                return jumpingImage;
        }

        public void setPortalId(byte portalId){
                this.portalId = portalId;
        }

        public byte getPortalId(){
                return portalId;
        }

        public void setHasFinished(boolean hasFinished){
                this.hasFinished = hasFinished;
        }

        public boolean hasFinished(){
                return hasFinished;
        }

        public void setFinishedTime(double finishedTime){
                this.finishTime = finishedTime;
        }

        public double getFinshedTime(){
                return finishTime;
        }

        public void setStanding(int standing){
                this.standing = standing;
        }

        public int getStanding(){
                return standing;
        }

        public void setEmote(Emote emote){
                this.emote= emote;
        }

        public Emote getEmote(){
                return emote;
        }

        public void setBallonAttached(boolean ballonAttached){
            this.balloonAttached = ballonAttached;
        }

        public boolean isBallonAttached(){
            return balloonAttached;
        }

        @Override
        public boolean equals(Object b){
                if(b instanceof Mouse){
                        return getName().equals(((Mouse)b).getName());
                }
                return false;
        }


	@Override
	public String toString() {
		return "Mouse [code=" + code + ", name=" + name + ", dead=" + dead
				+ ", score=" + score + ", codeForum=" + codeForum + "]";
	}

	public static enum Emote {
                Dance,
                Smile,
                Cry,
                Kiss,
                Angry,
                Clap,
                Sleep,
                Facepalm;

                public static Emote getEmote(int value) {
                    Emote[] vals = values();
                    if (value < vals.length) {
                        return vals[value];
                    }
                    else  {
                        return Dance;
                    }
                }	
        }
}
