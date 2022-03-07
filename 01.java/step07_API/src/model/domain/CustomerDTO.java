package model.domain; //domain �ܾ�� �ܾ� ���� �ǹ��ϱ⵵ ��

public class CustomerDTO {
	private String id;
	private int pw;
	
	/* �ڹٴ� ������ �ʼ�
	 * �ڵ�� ������ �� ���� ��� �⺻ ������ �ڵ�����
	 * �ʿ信 ���ؼ� ��������� �ʱ�ȭ�ϴ� �����ڴ� ���� ����
	 * - ������� : ȣ���� �ϵ� ���� �⺻ ������ ���� �ʼ�
	 * 
	 * ��ü ���� ����
	 * 	- ȣ���� CustomerDTO�� ���� ������ ���������δ� Object ��ü�� ���� ����
	 * 	CustomerDTO c =  new CustomerDTO("��", 20); // ���ڿ�, ���� �� �� �����͸� ���� ������ �޸� ����
	 */
	public CustomerDTO() {
		super();
	}
	public CustomerDTO(String id, int pw) {
		super(); //������ �ڵ� �߰�
		//but super([..]) �ڵ��ÿ��� �ڵ� ���� �Ұ�
		this.id = id;
		this.pw = pw;
	}
	//ȣ���� ���  id���� ���ڿ� Ÿ�Կ� �°� ��ȯ
	//Ȧ���� �� : caller
	//getter �޼ҵ�
	public String getId() {
		return id;
	}
	//setter �޼ҵ�
	public void setId(String id) { //��ö ����, parameter, argument, �Ű�����, �Ű�����, �μ�...
		this.id = id; //�� ����, ��� ���� �ʱ�ȭ
	}

	public int getPw() {
		return pw;
	}

	public void setPw(int pw) {
		this.pw = pw;
	}
	/* �ַ� domain(���� ǥ���ϴ�) Ŭ������ ������� �����Ǵ� ��ü���� println() ��½ÿ�
	 * toString() �ڵ� ȣ��
	 * ������ ������ ���ؼ� kava.lang.Object ���� �޼ҵ�� ������ ��ü�� �ּҰ� ��ȯ
	 * �ּҰ��� ���߽ÿ��� �����δ� ����� ���� ����
	 * ���� Ŭ�������� ����
	 */
	@Override //������ �޼ҵ� ���� : �ɼ�
	public String toString() {
		return "CustomerDTO : [id=" + id + ", pw=" + pw + "]";
	}
	

}
