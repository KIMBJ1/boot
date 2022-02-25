package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class StudentDTO {
	// �л� ���� : �̸� �й� ���� ���
	private String name;
	private int snumber;
	private int score;
	private char grade;

}
