package ee.ignorance.transformiceapi.protocol.server;

import java.util.List;


public class LoginSuccessResponse extends AbstractResponse {

	private String username;
	private int mouseId;
	
	private boolean admin;
	private boolean moderator;
	private boolean invite;
	
	public LoginSuccessResponse(List<String> rawMessage) {
		super(rawMessage);
	}

	@Override
	public void parse(List<String> rawMessage) {
		String username = rawMessage.get(1);
		int id = Integer.parseInt(rawMessage.get(2));
		setUsername(username);
		setMouseId(id);
		setInvite(rawMessage.get(3).equals("0")); // ?
		setModerator(rawMessage.get(3).equals("5") || rawMessage.get(3).equals("6"));
		setAdmin(rawMessage.get(3).equals("10"));
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getMouseId() {
		return mouseId;
	}

	public void setMouseId(int mouseId) {
		this.mouseId = mouseId;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public boolean isModerator() {
		return moderator;
	}

	public void setModerator(boolean moderator) {
		this.moderator = moderator;
	}

	public boolean isInvite() {
		return invite;
	}

	public void setInvite(boolean invite) {
		this.invite = invite;
	}
	
	

}
