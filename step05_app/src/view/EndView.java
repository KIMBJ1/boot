package view;

import model.StudentDTO;

public class EndView {

	public static void printAll(StudentDTO[] all) {
		for (StudentDTO v : all) {
			System.out.println("학생 정보 : " + v.getName() + " " + v.getSnumber() + " " + v.getScore() + " " + v.getGrade());
			System.out.println("학생 정보 주소 : " + v);
		}
	}
}
