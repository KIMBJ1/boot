package view;

import model.CustomerDTO;

public class EndView {

	public static void print(CustomerDTO c) {
		System.out.println(c.getId() + " &nd " + c.getGrade());
	}

	//모든 고객 정보 출력
	//forEach 사용 / println() 참조변수값 출력시 toSstring() 자동 호출
	public static void printAll(CustomerDTO[] all) {
		for(CustomerDTO v : all) {
			System.out.println(v);//v.toString()
		}
	}

	public static void printMsg(String msg) {
		System.out.println(msg);
	}
}
