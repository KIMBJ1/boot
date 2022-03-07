package step01.nonbuilder;



import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class People {
	private String name;
	private int age;
	
	//parameter가 없는 기본 생성자
	//생성자가 없는 경우 컴파일러가 생성해주는 생성자
	public People() {}

	//생성자 - 객체 생성시에 사용자가 저장하고자 하는 값으로 객체 생성
	public People(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	//상속시에 추가 학습
	/* java의 모든 클래스의 최상위 root 존재 = java.lang.Object
	 * - 변수와 메소드는 모든 클래스가 상속받아 보유하고 있는 상황
	 * - toString() 메소드만 고려
	 * 		-Object의 toString() 기능: 생성된 객체명과@위치명을 문자열로 반환
	 * - 단, 자식 클래스 관점에서 메소드 기능 수정 가능 : 메소드 재정의
	 * - 메소드 재정의(overriding, override)
	 * 		메소드 기능(body) 수정
	 */
	public String toString() {
		return name + " - " + age; //하나의 String으로 결합되어 반환
		//이거 없으면 step01.People@2db0f6b2 주소값
		//이거 있으면 KBJ - 1995
	}
	
	//참조 변수값 출력시에 toString() 자동 호출 즉 toString() 반환값이 출력
	public static void main(String [] args) {
		//parameter에 있는 생성자 호출해서 KBJ, 1995 저장
		/* People a1 = new People();
		 * a1.setName("asd");
		 * a1.setAge(1995
		 */
						
		People a1 = new People();
		a1.setName("asd");
		a1.setAge(1997);
		//이게 더 나음
		People a2 = new People("KBJ", 1995);

		System.out.println(a1); //step01.People@2db0f6b2
		System.out.println(a2); //주소 step01.People@3cd1f1c8 / 원하는 값 KBJ - 1995
	}
	
}
