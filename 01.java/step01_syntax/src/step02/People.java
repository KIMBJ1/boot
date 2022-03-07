package step02;

public class People {
	//변수 - 실제 사용 가능하게 메모리에 생성되는 시점 : 객체 생성 시
	//객체 자체를 생성하는 변수 멤버 변수
	String name; //선언
	int age; //선언
	
	//컴파일러가 자동으로 만들어주기는 하지만 생성자가 중요한 클래스는 타이핑을 한다
	//생성자(파라미터){로직}
	People(){}
	
	//메소드 - 사용하는 관점에서 개발
	//변수값 제공 또는 수정하는 메소드
	String getName() {
		return name; //호출
	}
	void setName(String newName) { //로컬 변수 : newName newAge args p1 4개 //선언
		name = newName; //호출&nd대입 멤버변수호출 = 로컬변수호출
	}
	int getAge() {
		return age; //호출
	}
	void setAge(int newAge) { //선언
		age = newAge; //호출 대입
	}
	
	public static void main(String[] args) { //선언
		//객체 생성 - name, age 메모리 생성 하면서 People 영역으로 관리
		// 단 주소값으로 데이터 활용, 실 주소값이 아닌 p1 변수 명으로 코드 상에서 사용
		People p1 = new People(); //선언
		System.out.println(p1.name); //호출
		
		//변수 호출로 값 대입 및 확인
		p1.name = "김이름";
		System.out.println(p1.name);
		
		//메소드 호출로 값 수정 및 확인
		p1.setName("김이박");
		System.out.println(p1.name);
		
		p1.setAge(25);
		System.out.println(p1.age);

	}

}
