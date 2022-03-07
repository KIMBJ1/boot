package step12.trade.dto;

public class User {
	private String nickname;
	
	public User() {
		super();
	}
	
	public User(String nickname) {
		super();
		this.nickname = nickname;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [nickname=");
		builder.append(nickname);
		builder.append("]");
		return builder.toString();
	}

}
