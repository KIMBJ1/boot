/* 학습 내용
 * 1. static 키워드 학습
 * 2. static 키워드 활용 영역
 * 	1. 멤버 변수에 선언 	- static 타입 변수;
 * 	2. 메소드에 선언	- static 리턴타입 메소드명(){}
 * 	3. static{}		- 걍 이렇게 생김
 */

package step01.basic;

public class L04Static {

	// 멤버변수 종류 구분 및 호출 문법 습득
	// 멤버 변수는 객체 생성 시점에 자동으로 기본 값 초기화
	// 실수 = 0.0, 정수 = 0, boolean = false, char = '|u0000' 이게 null
	// 모든 참조 타입 = null
	int i; // instance변수 : 객체 필수
	static int i2; // static 변수

	L04Static() {
		i++;
		i2++;
	}

	void m1() {
		System.out.println("일반 메소드 = instance 메소드");
	}

	static void m2() {
		System.out.println("static 메소드");
	}

	static {
		System.out.println("static 블록 1++++++***-------////================");
	}

	public static void main(String[] args) {

		L04Static l = new L04Static();
		System.out.println(l.i + " " + i2); // 결과값 1 1
		L04Static l2 = new L04Static();
		System.out.println(l2.i + " " + i2); // 결과값 1 2

		l.m1();
		l2.m1();
		m2();

		/*
		 * System.out.println(i2);
		 * 
		 * L04Static l = new L04Static(); System.out.println(l.i);
		 */

	}

}
