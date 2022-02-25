package controller;

import model.StudentDTO;
import model.Model;
import view.EndView;

public class Controller {

	public static void reqRes(int flag) {
		if (flag == 1) {
			EndView.printAll(Model.getStudents());
		} else if (flag == 2) {
			for (StudentDTO s : Model.getStudents()) {
				if (s.getScore() >= 80) {
					System.out.println(s.getName() + " 장학금 대상자");
				} else {
					System.out.println(s.getName() + " 장학금 미대상자");
				}
			}

		}
	}
}
