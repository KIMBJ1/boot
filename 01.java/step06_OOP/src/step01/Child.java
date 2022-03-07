package step01;

public class Child extends Parent{
	String job;
	
	public Child() {
		super(); // 생성자 첫라인에 필수 없으면 컴파일러가 자동 추가
				 //Object 객체 -> Parent 객체 생성 완료
				 // name age 메모리 생성
		System.out.println("child가 나중 생성");
	} //실행 종료, job 메모리 생성

	//printALL : 부모 그대로 받기
	void printAll() {
		super.printAll(); //부모(super) 클래스의 해당 메소드 로직 100% 그대로 적용하는 단일 문장 
		//부모클래스만 수정하면 자식클래스 변경 완료
//		System.out.println(name); //참조타입이니까 name.toString()으로 변경됨
//		System.out.println(age);
		//super.printAll(); 쓰면 이 두 줄이 필요 없어짐
		System.out.println(job);
	}

	@Override //재정의 애노테이션
	public String toString() {
		return name + " " +  age + " " + job;
	}
	
	public static void main(String[] args) {
		/* 생성된 객체
		 * Object -> Parent -> Child
		 *  c라는 변수는 Child타입
		 */
		Child c = new Child();
		System.out.println("toString재정의 전 : " + c); //null 0 null
													  //String toString() 안하면 : step01.Child@7de26db8
		
		c.name = "김이름";
		c.age = 1995;
		c.job = "asdf";
		
		System.out.println("toString재정의 후 : " + c); //name age job나오려면 toString 개선 -> 재정의
	}

}
