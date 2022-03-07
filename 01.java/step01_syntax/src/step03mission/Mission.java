/*
 * 미션 People.java Person.java PersonTest.java 실습후
 * 	- 하나의 클래스로만 구성했던 구조를 두개의 클래스로 구성
 * 	- 멤버 변수와 로컬 변수 구분 생성 소멸 시점
 * 	- 객체 생성의 개수를 증가해 보면서 하나의 클래스로 다수 데이터 관리하는 방법
 *  - 객체 생성 문법
 *  - 참조 별수의 필요성
 *  - 메소드 호출 문법
 *  - 변수 이름이 같을 경우 구분 this
 *  - jre 환경의 heap(객체만 저장, garbage collector - GC) / stack(로컬 변수 저장)
 *  - eclipse 자동 완성 기능
 *  - 명명규칙 및 메소드 개발 형식
 *  ======== 미션 ==========
 *  주제
 *   - 자동차 주제로 기존 코드 리뷰하면서 두개의 클래스로 개발
 *   
 */

package step03mission;

public class Mission {
	String carName;
	String color;
	int backnumber;
	
	public Mission() {}

	public String getcarName() {
		return carName;
	}
	public void setcarName(String carName) {
		this.carName = carName;
	}
	
	public String getcolor() {
		return color;
	}
	public void setcolor(String color) {
		this.color = color;
	}
	
	public int  getbacknumber() {
		return backnumber;
	}
	public void setbacknumber(int backnumber) {
		this.backnumber = backnumber;
	}
	
}
