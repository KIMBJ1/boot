package step02;

class Parent extends Object {
	String name;
	int age;

	Parent() {
		super();
	}

	void printAll() {
		System.out.println(name);
		System.out.println(age);
	}
}

public class Child extends Parent {
	String job;

	public Child() {
		super();
	}

	void printAll() {
		super.printAll();
//		System.out.println(job.toString());
		System.out.println(job);
	}

	public static void main(String[] args) {
		/* 컴파일은 부모 클래스부터 컴파일
		 * p.멤버변수와 메소드 문법 실행 시 자식 클래스부터 실행
		 * 즉 printAll() 실행 결과만으로도 재정의된 자식 메소드 호출
		 */
		Parent p = new Child(); //다형성, 상속 전제 따라서 가능한 문법
		p.name = "김이름";
		p.age = 1995;
		System.out.println("-------Parent에 값 대입");
		p.printAll();
		
		
		//자식만의 멤버변수에 부모타입 변수로 호출 시도
//		p.job = "IT"; //오류남
		//해결책 : 형변환 적용 - 부모타입을 자식타입으로 변환
		//형변환 문법 : 하위타입 변수 = (하위타입)상위타입;
		/* p는 생성된 Child 객체를 참조 즉 주소값
		 * 새로운 c라는 Child 변수에 p가 참조하는 동일한 객체를 대입
		 * 단 대입되는 시점에 Parent 타입이 상속관계의 하위 타입으로 변환되어 대입
		 * 하나의 객체를 p와 c가 동시에 참조
		 */
		
		System.out.println("-------형변환 X");
		p.printAll();
		Child c = (Child)p;
		c.job = "KING";
		System.out.println("-------형변환");
		c.printAll();
		System.out.println("-------형변환");
		p.printAll();
		
		c.name = "asdf";
		System.out.println("-------c이름 변경 p출력");
		System.out.println(p.name);
		p.name = "zxcv";
		System.out.println("-------p이름 변경 c출력");
		System.out.println(c.name);
		System.out.println("p, c 주소 : " + p + " " +  c);
	}
}