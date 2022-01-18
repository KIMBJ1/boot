package step12.trade.dto;
import step12.trade.dto.User;

public class Item {
	private String name;
	private int price;
	private int viewCnt;
	private User user;
	
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Item(String name, int price, User user) {
		super();
		this.name = name;
		this.price = price;
		this.user = user;
		this.viewCnt = 0;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	public void addViewCnt() {
		viewCnt++;
	}
	public User getUser() {
		return user;
	}
	
	public int getUserPw(User user) {
		return user.getPw();
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Item [name=");
		builder.append(name);
		builder.append(", price=");
		builder.append(price);
		builder.append(", seller = ");
		builder.append(user.getNickname());
		builder.append(", viewCnt=");
		builder.append(viewCnt);
		builder.append("]");
		return builder.toString();
	}
	
	
}
