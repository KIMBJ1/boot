/* 1.Object 는 모든 클래스의 상위타입
 * 2. 모든 객체 타입 다 수용
 * 3. 다형성 문법으로 생성된 객체들은 하위 타입의 변수에 대입 가능
 * 	= 형변환
 * 4. Object 변수 = "test"; 가능
 */
package step03.test;

public class OOPTest {

	//Object 변수 = "string"
	static Object m1() { //Object 타입으로 형변환 즉 다형성 적용되어 상위타입으로 변환되어 반환
		return "string"; //String 객체 생성 및 리턴
	}
	
	//문자열 2개, People 객체 등 다양한 타입의 객체들을 하나의 공간으로 관리
	//이상적인 데이터 타입은? - 배열?
	//고려사항 - String과 People는 다 다른 참조 타입
	// 서로 연관 없는 객체들 참조타입을 저장 및 관리하려면 배열 타입은 Object[]로 만들어야 함
	
	static Object[] m2() {
		Object[] o = {"string", "playdata", new Integer("3")};
		return o;
	}
	
	public static void main(String[] args) {
		
		System.out.println("-------step01");
		String s = (String)m1(); //단 s는 반드시 String타입이어야 함
		//Object 타입 변수들은 String 자식만의 멤버 호출 불가
		//String으로 형변환 후 String만의 멤버 호출
		System.out.println(s.charAt(3)); //String 문자열 중 4번째 출력
										 //charAt String 클래스에 존재
		
		System.out.println("-------step02");
		Object[] v = m2();
		String v1 = (String)v[1];
		System.out.println("-------playdata에서 p");
		System.out.println(v1.charAt(0));
		/*public int intValue(){ 
		 * Integer라는 객체가 보유한 값을 int기본 타입으로 변환해서 반환하는 메소드
		 * }
		 * 
		 * main 메소드에서 m2()호출
		 * 첫번째 출력 : playdata에서 p
		 * 두번째 출력 : Integer 객체 뽑아서 intValue() 호출 및 출력
		 */
		System.out.println("-------Integer 객체 뽑아서 intValue() 호출 및 출력");
		Integer v2 = (Integer)v[2];
		System.out.println(v2.intValue());
		
	}
}
