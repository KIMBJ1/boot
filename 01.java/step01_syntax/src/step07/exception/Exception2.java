//예외처리 문장 학습

package step07.exception;

class B{
	static {
		System.out.println("B Class 로딩");
	}
}
public class Exception2 {
	
	public static void m1() {
		System.out.println("예외 발생 없음");
	}

	//런타임 예외
	public static void m2() {
		System.out.println("실행 예외");
		System.out.println(10/0);// 0으로 나누기*************************************
		System.out.println("try~catch 문장 없으므로 예외 발생 -> 실행 불가");
	}
	
	//컴파일 예외 - try~catch 문장 필수
	public static void m3() {
		try{
			System.out.println("로딩 전01");
			Class.forName("step07.exception.B"); //문제 발생 가능성 있는 라인
			System.out.println("로딩 후01");
		}
		catch(ClassNotFoundException e) { // 실제 예외 발생 시 처리하는 블록
			System.out.println("B 로딩시 문제 발생01");
		}
		try{
			System.out.println("로딩 전02");
			Class.forName("step07.exception.Basdf"); //문제 발생 가능성 있는 라인
			System.out.println("로딩 후02");
		}
		catch(ClassNotFoundException e) { // 실제 예외 발생 시 처리하는 블록
			System.out.println("B 로딩시 문제 발생02");
		}finally {
			//견고한 필수 로직에 권장하는 블록 : sys. 자원 반환 로직으로 사용
			System.out.println("예외 발생 여부와 무관하게 99% 실행 보장 블록");
		}
		System.out.println("B블록 언제나 실행되는 로직");
	}
	
	//예외 발생해서 직접 호출한 곳으로 throws 해보기
	//m4() 호출한 곳에서 예외 처리
	//java.lang.Exception 클래스를 활용
	//0107-학습내용.txt/2.3단계
	//로직 - 값이 playdata가 아니면 예외 발생
	//! : 부정연산자, !true -> false. !false -> true
	/* throws - body에서 발생될 수도 있는 예외를 호출한 곳으로 던지기 위해 메소드 선언구에 쓰느 키워드
	 * throw - 메소드 body에서 실제 상황상 예외를 생성해서 던지는 키워드, new랑 붙음
	 */
	public static void m4(String v) throws Exception{
		//playdata가 아닌 경우만 true가 되는 조건식
		//if 조건이 참인 경우 if 블록 즉 예외객체 생성과 던짐 로직으로 메소드 자동 종료
		if(!v.equals("playdata")) {
			//Exception의 message 멤버 변수값 초기화하는 생성자
			throw new Exception("playdata가 아님, 문제 심각");
		}
		System.out.println("playdata인 경우에만 실행되는 로직들");
	}
	
	public static void main(String[] a) {
		m1();
//		m2(); //발생 확인
		m3();

		try {
			m4("playdata");
			m4("asdf");
		} catch (Exception e) {
			System.out.println(e.getMessage()); //예외 객체생성자에 적용한 parameter값 반환하는 메소드
			e.printStackTrace();// 발생된 문제의 위치 출력
		}
	}
}

//문제 4-5문제 만들기
