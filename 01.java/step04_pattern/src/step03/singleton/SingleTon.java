package step03.singleton;

//�����ϴ� ��ɵ� ��� �����ϰ� read �������� ��� ����
public class SingleTon {

	private static SingleTon instance = new SingleTon();
	private SingleTon() {}
	
	public static SingleTon getInstance() {
		return instance;
	}
	//�پ��� ��ɵ��� �޼ҵ尡 �ִٰ� ����
}
