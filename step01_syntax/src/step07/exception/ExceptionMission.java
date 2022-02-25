//int 2개 나눗셈 기능 구현할 것
//0으로 나눌경우 try~catch 사용해서 예외처리 하세요
package step07.exception;

public class ExceptionMission {
	
	public static void m(int v1, int v2) throws Exception{
		if(v2 == 0) {
			throw new Exception("나눗셈 불가");
		}
		System.out.println(v1/v2);
	}
	
	public static void main(String[] args) {
		try {
			m(50,2);
			m(30,3);
			m(10,0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();// 에러 위치 표시
		} finally {
			System.out.println("fin");
		}
	}
}