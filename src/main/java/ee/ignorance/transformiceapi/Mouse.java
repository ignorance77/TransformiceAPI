package ee.ignorance.transformiceapi;


public class Mouse {

	private int code;
	private String name;
	private boolean dead;
	private int score;
	
	public static Mouse parse(String[] mouseData) {
		Mouse mouse = new Mouse();
		String name = mouseData[0];
		int code = Integer.parseInt(mouseData[1]);
		int score = Integer.parseInt(mouseData[3]);
		boolean dead = mouseData[2].equals("1");
		mouse.setName(name);
		mouse.setDead(dead);
		mouse.setCode(code);
		mouse.setScore(score);
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

	@Override
	public String toString() {
		return "Mouse [code=" + code + ", name=" + name + ", dead=" + dead
				+ ", score=" + score + "]";
	}
	
}
