package controller;

import model.CustomerDTO;
import model.Model;
import view.EndView;

public class Controller {
	
	//1 요청 : 고객 한 명 정보 제공
	//2 요청 : 모든 고객 정보 제공
	/*조건 : 1인가?2인가? 1이나 2가 아닌가?
	 * 정수 비교 연산자(동등비교연산자) ==
	 */
	public static void reqRes(int flag) {
		if(flag == 1) {
			EndView.print(Model.getCustomer());
		}else if(flag == 2) {
			/*EndView.printAll(Model.getCustomers()); 실행 순서
			 * Model.getCustomers)
			 * -> EndView.printAll()
			 * 	->;
			 */	
			 	
			EndView.printAll(Model.getCustomers());
		}else {
			EndView.printMsg("요청 오류. 요청은 1 또는 2만 가능");
		}
	}
}
