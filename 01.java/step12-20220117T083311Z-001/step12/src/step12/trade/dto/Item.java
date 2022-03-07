package step12.trade.dto;

public class Item {
	private String name;
	private int price;
	private User seller;
	private int viewCnt;
	
	public Item() {
		super();
	}
	
	public Item(String name, int price, User seller) {
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
	
	public User getSeller() {
		return seller;
	}
	
	public void setSeller(User seller) {
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
		return "Item [name=" + name + ", price=" + price + ", seller=" + seller.getNickname() + ", viewCnt=" + viewCnt + "]";
	}
	
}