package step03.singleton;

//존재하는 기능들 사용 가능하게 read 관점에서 기능 제공
public class SingleTon {

	private static SingleTon instance = new SingleTon();
	private SingleTon() {}
	
	public static SingleTon getInstance() {
		return instance;
	}
	//다양한 기능들의 메소드가 있다고 가정
}
