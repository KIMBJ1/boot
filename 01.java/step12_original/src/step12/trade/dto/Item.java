package step12.trade.dto;

public class Item {
	private String name;
	private int price;
	private String seller;
	private int viewCnt;
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Item(String name, int price, String seller) {
		super();
		this.name = name;
		this.price = price;
		this.seller = seller;
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
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Item [name=");
		builder.append(name);
		builder.append(", price=");
		builder.append(price);
		builder.append(", seller=");
		builder.append(seller);
		builder.append(", viewCnt=");
		builder.append(viewCnt);
		builder.append("]");
		return builder.toString();
	}
	
	
}
