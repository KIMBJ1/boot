package model;

public class Model {

	// builder를 사용한 학생 정보 입력
	public static StudentDTO[] getStudents() {
		StudentDTO[] c = { StudentDTO.builder().name("student1").snumber(1111).score(100).grade('A').build(),
				StudentDTO.builder().name("student2").snumber(1112).grade('B').build(),
				StudentDTO.builder().name("student3").snumber(1113).score(80).grade('C').build(),
				StudentDTO.builder().name("student4").snumber(1114).score(70).grade('D').build(),
				StudentDTO.builder().name("student5").snumber(1115).score(60).grade('F').build() };

		return c;
	}

}
