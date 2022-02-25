/*
 * 학습 내용
 * 
 * class 내부에 구현해야 하는 요소들 : 변수 생성자 메소드
 * 
 * 1. 변수 선언 및 호출
 * 	- 데이터
 * 	- 타입 변수명;
 * 	- 타입 변수명 = 값;
 * 2. 생성자 구현 및 호출
 * 	- 클래스 명과 동일, (){}필요
 * 	- only 객체 생성 용도
 * 		- new 라는 객체 생성 키워드
 * 		- 객체 생성 문법
 * 			- new 생성자([값]);
 * 		- 클래스가 보유한 메소드 호출의 첫 단계는 객체 생성후 참조 변수로 메소드 호출
 * 3. 메소드 구현 및 호출
 * 	- 객체 생성시에 호출되는 생성자와 다름
 * 	- 반환타입 메소드명 (arguments){[logif]}
 */

package step01.basic;

public class L03Review {
	String name;
	int age;
	
	L03Review(){} // 미구현시 컴파일 시점에 자동으로 추가
	// 클래스 이름과 같고 (){}있는 생성자
	
	//메소드 생성
	//이름 반환하는 getName()
	String getName() {
		return "김씨";
	}
	
	public static void main(String[] args) {
		//여기서는 변수 만드는거 ㄴㄴ
		//name = "김이름"; 이러면 에러 아직 name 변수 없음
		
		L03Review newvariable = new L03Review(); //객체 생성 &nd 메모리 생성
		
		System.out.println(newvariable.name);
		//main에서 name 호출하지 않으면 null
		//ctrl alt 아래 방향키로 코드 복사
		//alt 아래 방향키로 코드 이동
		newvariable.name = "김이름";
		System.out.println(newvariable.name);
//========		String getName		==============================
		
		String n = newvariable.getName();
		System.out.println(n);
		
/*
 * ==========
 * 강사 질문
 * 1. name age 변수 즉 데이터가 실제 저장 가능(사용 가능)하게 시스템에 메모리를 생성하는 시점?
 * 	= 객체 생성 시점
 */
	}

}
