package step01.basic;

public class L02Method {

	/*
	 * 생성자 용도 - 객체를 만들때 필수로 사용되는 요소 개발자가 코드로 미구현시 컴파일 시점에 자동 생성 - 자바 기반의 객체 지향 기본임
	 * 여기서는 L02Method라는 이름으로 자동 생성
	 */

	// 두 개의 정수 받아서 합치기
	int sum(int v1, int v2) {
		return v1 + v2;
	}

	int sum2(int v1, int v2) {
		int result = v1 + v2;
		return result;
	}

	// java L02Method 실행 요청시 해당 클래스의 main 메소드를 jre에서 자동 호출
	// main() 제외한 우리가 개발한 모든 메소드(기능)는 직접 코드로 호출
	public static void main(String[] args) {
		/*
		 * 단순 메소드 기능들을 호출해서 사용하기 위해 문법적으로 객체 생성 sum() 호출해서 바ㅏㄴ환받은 결과값을 main()에서 콘솔창에 출력
		 * 객체 생성 - sum(), sum2() 보유한 클래스로부터 객체 생성 L02Method(이게 int, String같은 거임)
		 * variablename - java의 확장성 내가 만든 클래스는 자바 타입으로 사용 가능 클래스를 기반으로 새로운 데이터가 생성되었다는
		 * 객체 생성으로 간주
		 */

		L02Method newvariable = new L02Method(); // new : 객체 생성 키워드
													// L02Method() : 생성자
		// System.out.println(newvariable);
		// 이거 결과값
		// step01.basic.L02Method@123a439b
		// newvariable : 생성된 객체를 참조하는 변수로 주소값 보유, 참조변수(reference 변수)

		int daedab = newvariable.sum(10, 15);
		int daedab2 = newvariable.sum2(17, 25);
		System.out.println("10 + 15 : " + daedab);
		System.out.println("17 + 25 : " + daedab2);

	}
}