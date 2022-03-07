/** 
 * PROJECT  : 재능기부 프로젝트
 * NAME  :  Donator.java
 * DESC  :  기부자 정보(Data)
 * 
 * @author  
 * @version 1.0
*/
package step02.probono.model.dto;

public class Donator {
	/** 기부자 사번 */
	private int empno;
	
	/** 기부자 이름 */
	private String ename;
	
	/** 기부자 이메일 */
	private String email;
	
	/** 기부자 재능 */
	private String talent;

	public Donator() {}
	public Donator(int empno, String ename, String email, String talent) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.email = email;
		this.talent = talent;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTalent() {
		return talent;
	}

	public void setTalent(String talent) {
		this.talent = talent;
	}

	/* StringBuilder
	 * 1. 문자열 표현하는 API
	 * 2. String만 ""표기로 자동 객체 생성
	 * 3. new와 생성자로 조합으로만 객체 생성
	 * 4. String 특징
	 * 	1. 한번 생성된 객체의 객신 불가
	 * 	2. 이미 만들어진 객체의 내용을 수정시에는 heap에 새로운 문자열 객체가 생성되는 원리
	 * 		"a" + "b" -> a 데이터의 객체 생성 / b 문자열 객체 생성 / ab 라는 문자열 객체 생성
	 * 	3. 실시간 가변적인 문자열 사용은 고려
	 * 		- 객체 생성에 따른 자원 낭비
	 * 5. 가변적인 문자열 객체 생성에 적합
	 * 	- 생성된 객체가 저장된 메모리에 갱신 가능
	 * 	- "a" + "b" -> a 데이터의 객체 생성 / b 문자열 객체 생성 / a메모리에 b추가
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("기부를 희망하는 사원번호 : ");
		builder.append(empno);
		builder.append(", 사원명 : ");
		builder.append(ename);
		builder.append(", 이메일 주소 : ");
		builder.append(email);
		builder.append(", 재능 : ");
		builder.append(talent);
		return builder.toString();
	}

}