package step01;

public class Parent extends Object{
	String name; //참조타입
	int age; //기본타입
	
	public Parent() {
		super(); //부모 클래스의 멤버와 자식 클래스의 멤버 이름이 같을 경우 super 키워드를 사용하여 구별
				 // Object 객체생성 완료
		System.out.println("parent가 먼저 생성");
	}
	
	void printAll() {
		System.out.println(name); //참조타입이니까 name.toString()으로 변경됨
		System.out.println(age);
	}

}
