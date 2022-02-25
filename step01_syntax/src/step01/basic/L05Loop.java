package step01.basic;

import org.junit.Test;

//1!5까지 반복 출력
//1 : 초기치(시작) / 5까지 : 조건 / 1부터 1씩 증가(증가치)
//forM
//int i = 1; 	 /  i <= 5;  / i++
/*
 * - 반복 횟수가 나름 제한이 있을 경우 권장
 * - 조건이 true인 경우만 실행
 * for(초기치;조건식;증감식){
 * 	참일때만 실행 블럭
 * }
 * ===========================================
 * - 무한 반복을 요할때 권장 / 반복 횟수 불명확할때
 * - 조건이 true인 경우만 실행
 * 초기치;
 * while(조건식){
 * 	참일때만 실행 블럭
 * 증감식;
 * }
 * 
 * - 조건을 떠나서 무조건 한번은 실행 보장해야 할 경우 -------------- 실습은 안하고 넘어감 필요하면 공부해라
 * 초기치;
 * do{
 * 	참일때만 실행 블럭
 * 	증감식;
 * }while(조건식);
 */
public class L05Loop {
	
//	@Test
	public void forM() {
		for(int i = 1; i <= 5; i++) {
			System.out.println(i);
		}
	}
	@ Test
	public void WhileM() {
		System.out.println("while문장 돌리기");
		int i = 1;
		while(i <= 5) {
			//조건식이 참일때 실행
			System.out.println(i);
			i++;
		}
		
		
	}

}
