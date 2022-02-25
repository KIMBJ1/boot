/* 학습 내용
 * 1. API 응용
 * 	- Application Programming Interface
 * 	- 이미 구현되서 사용 가능하게 제공해주는 코드들
 * 		클래스 / 변수 / 생성자 / 메소드
 * 	- library라고 표현하기도 함(lib)
 * 
 * 2. 함축 표현
 * 	src - source
 * 	lib - library
 * 	bun - binary
 * 
 * 3. API 활용 문법
 * 	1. 변수 / 생성자 / 메소드 호출 문법
 * 	2. 호출 문법
 * 		1. 객체 생성 직후에 호출
 * 			- instance 변수와 instance 메소드
 * 		2. 객체 생성없이 호출
 * 			- static 변수와 static 메소드
 * 	3. 외부 package 사용
 * 		- import package명.class명;
 * 		- java.lang package만 유일하게 import 생략 가능
 * 
 */


package step05.apply;

public class A01APITest {

	public static void main(String[] args) {
		// java.lang.Math 클래스의 메소드 활용
		// -3 값 주고 절대값(abs) 반환 int 주고 int 반환 받아 출력
		System.out.println(Math.abs(-3));
		
		//이 문자열에서 '?번째 문자'만 출력
		
		/*API 개발자 관점
		 * 문자열 String 데이터 존재하는 전재
		 * 숫자 받아서argument 해당 숫자 위치값 글자 하나char 반환
		 * 
		 * char ?(int index){
		 * 	문자열 객체에서 index내 해당 char 차출 및 반환
		 * }형태일 것
		 * 
		 * 경우의 수 static이면?
		 * static char ?(int index){
		 * 	문자열 객체에서 index내 해당 char 차출 및 반환
		 * }
		 * 
		 * System.out.println(String.charAt(1)); 안됨
		 * 
		 * 굳이 static 선언하려면
		 * static char charAt(String data, int index){
		 * 	parameter로 받은 문자열 객체에서 인덱스 내 해당 char 착출 및 반환
		 * 
		 */
		String data = "기술 지적자산 가치 상승 - 기원";
		System.out.println(data.charAt(5));
		
		/*
		 * java.lang.Integer 라는 클래스의 메소드 사용
		 * "3" -> 3으로 변경해서 출력
		 */
		
		System.out.println(Integer.parseInt("57"));
		
		/* int로 변환 불가 포멧
		 * 차후에 Exception 즉 처리 가능한경미한 에러 고려도 학습 필수
		 * System.out.println(Integer.parseInt("가나다라"));
		 * 이런거
		 */
		
	}

}
