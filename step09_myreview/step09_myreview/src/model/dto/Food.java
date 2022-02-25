package model.dto;

public class Food {
	private String foodno;
	private String foodname;
	private String foodtype;
	private int price;
	
	public Food() {
		super();
	}

	public Food(String foodno, String foodname, String foodtype, int price) {
		super();
		this.foodno = foodno;
		this.foodname = foodname;
		this.foodtype = foodtype;
		this.price = price;
	}

	public String getFoodno() {
		return foodno;
	}

	public void setFoodno(String foodno) {
		this.foodno = foodno;
	}

	public String getFoodname() {
		return foodname;
	}

	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}

	public String getFoodtype() {
		return foodtype;
	}

	public void setFoodtype(String foodtype) {
		this.foodtype = foodtype;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Food [foodno=" + foodno + ", foodname=" + foodname + ", foodtype=" + foodtype + ", price=" + price
				+ "]";
	}
	
	
}


