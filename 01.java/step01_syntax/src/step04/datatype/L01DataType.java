/* 학습내용
 * 1. 데이터 타입 학습
 * 2. 데이터 타입이 활용이 되는 문법적인 위치
 * 	1. 멤버 변수, 로컬 변수 선언시 타입
 * 		- 로컬 : 생성자, 메소드 argument와 {} 내부에 선언
 * 	2. 리턴 타입
 * 3. 데이터 타입 종류
 * 	1. 기본 타입 (내장 타입, built in)
 * 		1. 총 8가지
 * 		2. class 미존재 상태로 소문자로 정해져 있음
 * 		3. 형태로 구분
 * 			문자형 / 논리형 / 실수형 / 정수형
 * 		4. 형태별로 사이즈로 세분화
 * 			1. 문자형 - char, 16비트(다국어 지원 사이즈)
 * 			2. 논리형 - boolean(true or false)
 * 			3. 실수형 - float, 32bit / double, 64bit
 * 			4. 정수형 - byte, 8bit / short, 16bit/ long, 64bit / int, 32bit
 * 	2. 객체 타입 (참조 타입, class type)
 * 		1. 기본이 아닌 모든 타입
 * 		2. class를 기반으로 타입 생성
 * 		3. API 즉 이미 만들어서 개발자에게 사용하라고 제공하는 library에 다수의 class 즉 타입 존재
 * 			- String
 * 		4. 문자열 : String.java로 제공되는 클래스, 사용빈도가 높아서 기본 타입처럼 문법을 제시
 * 		5.객체 생성 문법
 * 			타입 변수 = new 생성자([...]);
 * 			String 변수 = new String([문자열]); 원래 이게 맞음 but
 * 			String 변수 = "문자열"; 표기만으로 자동으로 String 객체 생성
 * 		6. 생성된 객체가 실제 저장되는 메모리 - heap
 * 			- heap 메모리 특징
 * 				- 객체만 저장
 * 				- 생성되는 객체는 보유한 모든 멤버 변수들 공간을 생성 관리
 * 				- 객체들 메모리 회수는 garbage collector(GC)
 */


package step04.datatype;

public class L01DataType {
	
	String getName() {
		String s = "김이름";
		return s;
	}
	
	Person getPerson() {
		Person p = new Person();
		return p;
	}
	
	void setName(String name) {
		String n = "너의 이름은 : " + name;
	}
	
	void setPerson(Person p) {
		Person p2 = p;
	}
		
	public static void main(String[] args) {
		L01DataType l = new L01DataType();
		String n = l.getName();
		

	}

}
