package step12.trade.model.dto;

import step12.trade.view.Item;

public class Trade {
	private Seller sname;
	private Buyer bname;
	private Item sitem;
	
	public Trade() {}

	public Trade(Seller sname, Buyer bname, Item sitem) {
		super();
		this.sname = sname;
		this.bname = bname;
		this.sitem = sitem;
	}

	public Seller getSname() {
		return sname;
	}

	public void setSname(Seller sname) {
		this.sname = sname;
	}

	public Buyer getBname() {
		return bname;
	}

	public void setBname(Buyer bname) {
		this.bname = bname;
	}

	public Item getSitem() {
		return sitem;
	}

	public void setSitem(Item sitem) {
		this.sitem = sitem;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Trade [sname=");
		builder.append(sname);
		builder.append(", bname=");
		builder.append(bname);
		builder.append(", sitem=");
		builder.append(sitem);
		builder.append("]");
		return builder.toString();
	}
	
	

}
