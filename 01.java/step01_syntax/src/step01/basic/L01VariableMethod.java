// 한 라인 주석

/* 다중 라인 주석
 * block 주석
 */

/* 학습 내용
 * 	1. 자바 문법의 변수
 *  	- 타입 변수명 = 값;
 *  
 *  2. 예시
 *  	- 정수 두개의 변수로 연산기능 수행
 *  	- 분해
 *  		- 변수 두개 : 정수 타입
 *  		- 연산기능 - 사칙 연산의 경우 각 연산을 수행 가능한 4개의 메소드
 *  			- 연산된 결과값을 어떻게 처리할 것?
 *  				1. 콘솔창에 단순 출력
 *  				2. 이 기능을 수행할 곳 로직의 위치로 값을 제공 : 여기서는 이걸로 하겠음
 *  					- 메소드 호출 -> 실행하면서 연산 수행 -> 수행 한 결과를 호출한 곳으로 반환(return)
 *  
 *  3. 예시를 기반으로 한 구현
 *  	1. 더하기
 *  		- 수행시에 두개의 숫자값 받음 -> 더하기 수행 -> 결과값 반환
 *  		
 *  		정수 더하기(값1, 값2){
 *  			값1 + 값2;
 *  			return 결과값
 *  		}
 *  
 *  		이 메소드 개발자 : 나
 *  		이 메소드 호출해서 사용할 사람 : 다른 사람들
 *  			- 사용자는 메소드 선언구만 보고 호출해서 사용을 한다
 *  			- 메소드 구현부까지 하나하나 확인 불필요
 */

package step01.basic;

public class L01VariableMethod {

	// asdf
	int sum(int v1, int v2) {
		return v1 + v2;
		// return 있음

	}

	void sum2(int v1, int v2) {
		// void : return 없을 때
		System.out.println(v1 + v2);
		// return 없음
	}

	double div(int v1, int v2) {
		return v1 / v2;

	}

	void div2(int v1, int v2) {
		System.out.println(v1 / v2);
		// return 없음
	}

	// 김이름 문자열 반환하는 메소드 구현
	String getName() {
		return "김이름";
	}

	int getAge() {
		return 30;
	}

	double getPay() {
		return 3.5;
	}

	public static void main(String[] args) {

		String name = "김이름";
		int age = 28;

		System.out.println(name);
		System.out.println(age);
		System.out.println(name + " " + age);

	}

}
