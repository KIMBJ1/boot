/*
 * �̼� People.java Person.java PersonTest.java �ǽ���
 * 	- �ϳ��� Ŭ�����θ� �����ߴ� ������ �ΰ��� Ŭ������ ����
 * 	- ��� ������ ���� ���� ���� ���� �Ҹ� ����
 * 	- ��ü ������ ������ ������ ���鼭 �ϳ��� Ŭ������ �ټ� ������ �����ϴ� ���
 *  - ��ü ���� ����
 *  - ���� ������ �ʿ伺
 *  - �޼ҵ� ȣ�� ����
 *  - ���� �̸��� ���� ��� ���� this
 *  - jre ȯ���� heap(��ü�� ����, garbage collector - GC) / stack(���� ���� ����)
 *  - eclipse �ڵ� �ϼ� ���
 *  - ����Ģ �� �޼ҵ� ���� ����
 *  ======== �̼� ==========
 *  ����
 *   - �ڵ��� ������ ���� �ڵ� �����ϸ鼭 �ΰ��� Ŭ������ ����
 *   
 */

package step03mission;

public class Mission {
	String carName;
	String color;
	int backnumber;
	
	public Mission() {}

	public String getcarName() {
		return carName;
	}
	public void setcarName(String carName) {
		this.carName = carName;
	}
	
	public String getcolor() {
		return color;
	}
	public void setcolor(String color) {
		this.color = color;
	}
	
	public int  getbacknumber() {
		return backnumber;
	}
	public void setbacknumber(int backnumber) {
		this.backnumber = backnumber;
	}
	
}
