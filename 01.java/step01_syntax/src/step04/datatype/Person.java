/*
 * 순수하게 사람 정보를 보유 및 수정 즉 사람 데이터 전담 클래스
 * this : name = name 불가
 * 로컬변수 = 멤버 변수인 경우 멤버 변수를 지정하는 키워드
 * 	즉 자기 자신의 객체를 참조하는 특별한 키워드
 */

package step04.datatype;

public class Person {
	String name;
	int age;
	
	public Person() {}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
