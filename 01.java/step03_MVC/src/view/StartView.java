package view;

import controller.Controller;

public class StartView {

	/*client가 1로 요청시 고객 한명 정보 요청
	 *client가 2로 요청시 모든 고객 정보 요청
	 */
	public static void main(String[] args) {
		System.out.println("******고객 한 명 정보 요청");
		Controller.reqRes(1);

		System.out.println("******모든 고객 정보 요청");
		Controller.reqRes(2);
		
		System.out.println("******잘못된 정보 요청");
		Controller.reqRes(99);
		
	}

}
