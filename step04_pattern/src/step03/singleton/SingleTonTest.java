/* 학습 내용
 * singleton design pattern
 * 1. server의 물리적인 자원의 적약측면에서 필요한 메커니즘
 * 2. server 내부에 실행 시에 객체수는 무조건 하나만 생성 보장
 * 3. 개발 방식
 * 	1. 객체 생성 금지 - 외부에서 객체 생성 금지
 * 		private 생성자(){}
 * 	2. 외부에서 이 객체의 다른 기능(메소드)들 활용 방법
 * 		1. 해당 클래스 내에서 객체 생성
 * 		2. 생성된 객체를 메소드로 반환
 */

package step03.singleton;

public class SingleTonTest {
	public static void main(String[] args) {
		
		SingleTon s = SingleTon.getInstance();
		//SingleTon의 메소드 사용해야 하는 로직
	}
}