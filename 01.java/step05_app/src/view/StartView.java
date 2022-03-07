
package view;

import controller.Controller;

public class StartView {

	public static void main(String[] args) {
		// reqRes를 1로 요청할 경우 학생 정보 출력
		System.out.println("******학생 정보");
		Controller.reqRes(1);

		// reqRes를 2로 요청할 경우 장학금 대상 정보 출력
		System.out.println("******장학금 정보");
		Controller.reqRes(2);

	}

}
