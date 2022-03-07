package step12.trade.view;

import step12.trade.model.dto.Buyer;
import step12.trade.model.dto.Seller;

public class Item {
	private Seller sitem;
	private Buyer bitem;
	
	public Item() {}
	
	public Item(Seller sitem, Buyer bitem) {
		super();
		this.sitem = sitem;
		this.bitem = bitem;
	}

	public Seller getSitem() {
		return sitem;
	}

	public void setSitem(Seller sitem) {
		this.sitem = sitem;
	}

	public Buyer getBitem() {
		return bitem;
	}

	public void setBitem(Buyer bitem) {
		this.bitem = bitem;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Item [sitem=");
		builder.append(sitem);
		builder.append(", bitem=");
		builder.append(bitem);
		builder.append("]");
		return builder.toString();
	}

}
