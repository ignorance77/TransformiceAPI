package ee.ignorance.transformiceapi;


public class Mouse {

	private int code;
	private String name;
	private boolean dead;
	private int score;
	private int codeForum;
	
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

	@Override
	public String toString() {
		return "Mouse [code=" + code + ", name=" + name + ", dead=" + dead
				+ ", score=" + score + ", codeForum=" + codeForum + "]";
	}
	
}
