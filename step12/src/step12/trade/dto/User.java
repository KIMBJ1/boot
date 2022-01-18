package step12.trade.dto;

public class User {
	private String nickname;
	private int pw;

	public User() {
		super();
	}

	public User(String nickname, int pw) {
		super();
		this.nickname = nickname;
		this.pw = pw;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getPw() {
		return pw;
	}

	public void setPw(int pw) {
		this.pw = pw;
	}

	@Override
	public String toString() {
		return "User [nickname=" + nickname + ", pw=" + pw + "]";
	}
}