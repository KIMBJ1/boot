package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor //파라미터가 없는 생성자를 생성
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CustomerDTO {
	//private 외부에 은닉
	private String id;
	private int pw;
	private char grade; // gold(g) silver(s) 두 레벨만 있다고 가정
	private String job;
	
	//grade값에 유효한 값만 저장 가능한 조건식 적용 (유효성 적용)
	//유효한 데이터만 저장 가능하게 하는 rule - 절대 타입만 맞다고 해서 대입 가능한 상황 금지시켜야 함
	//변수를 외부에서 호출 불가능하게 막고 유효성 코드로 검증 후에 대입
	//개발 관점 : 변수를 외부에서 차단(private)
	//  유효성 코드로 검증 메소드는 제한 없이 허용(public)
	public void setGrade(char grade) {
		//'는 char "는 문자열
		if(grade == 'g' || grade == 's') {
			this.grade = grade;
		}else {
			System.out.println("등급 오류");
		}
	}
}
