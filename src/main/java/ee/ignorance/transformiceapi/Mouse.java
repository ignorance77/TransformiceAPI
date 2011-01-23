package ee.ignorance.transformiceapi;


public class Mouse {

	private int code;
	private String name;
	private boolean dead;
	private int score;
	private int codeForum;

        private int posX = 0;
        private int posY = 0;
        private int movX = 0;
        private int movY = 0;
        private boolean goingLeft = false;
        private boolean goingRight = false;
        private boolean jumping = false;
        private byte jumpingImage = 0;
        private byte unk = 0;
	
	public static Mouse parse(String[] mouseData) {
		Mouse mouse = new Mouse();
		String name = mouseData[0];
		int code = Integer.parseInt(mouseData[1]);
		int score = Integer.parseInt(mouseData[3]);
		int codeForum = Integer.parseInt(mouseData[8].trim());
		boolean dead = mouseData[2].equals("1");
		mouse.setName(name);
		mouse.setDead(dead);
		mouse.setCode(code);
		mouse.setScore(score);
		mouse.setCodeForum(codeForum);
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
                this.movY = movX;
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

        public void setUnk(byte unk){
                this.unk = unk;
        }

        public byte getUnk(){
                return unk;
        }


	@Override
	public String toString() {
		return "Mouse [code=" + code + ", name=" + name + ", dead=" + dead
				+ ", score=" + score + ", codeForum=" + codeForum + "]";
	}
	
}
