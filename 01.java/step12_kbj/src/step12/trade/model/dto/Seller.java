package step12.trade.model.dto;

public class Seller {

	private String sname;
	private String sitem;

	public Seller() {}
	
	public Seller(String sname, String sitem) {
		super();
		this.sname = sname;
		this.sitem = sitem;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSitem() {
		return sitem;
	}

	public void setSitem(String sitem) {
		this.sitem = sitem;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("판매자 이름=");
		builder.append(sname);
		builder.append(", 판매 물건=");
		builder.append(sitem);
		builder.append("]");
		return builder.toString();
	}

}
