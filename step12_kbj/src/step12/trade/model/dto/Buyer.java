package step12.trade.model.dto;

public class Buyer {

	private String bname;
	private String bitem;

	public Buyer() {}
	
	public Buyer(String bname, String bitem) {
		super();
		this.bname = bname;
		this.bitem = bitem;
	}

	public String getSname() {
		return bname;
	}

	public void setSname(String bname) {
		this.bname = bname;
	}

	public String getSitem() {
		return bitem;
	}

	public void setSitem(String bitem) {
		this.bitem = bitem;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("������ �̸�=");
		builder.append(bname);
		builder.append(", ���� ����=");
		builder.append(bitem);
		builder.append("]");
		return builder.toString();
	}

}
