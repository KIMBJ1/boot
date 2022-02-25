package step02.builder;

import lombok.Builder;
import lombok.Data;

@Builder
@Data //@Getter @Setter @ToString 등등 합쳐진거
public class People {
	private String name;
	private int age;
		
	
	public static void main(String [] args) {
		
		// 다수의 변수중에 name 변수값만 초기화 하면서 객체 생성하는 구조
		// 애노테이션 @Builder
		// 0106_학습내용.txt\3. 질문\경우의 수 3
		/*
		 * People.builder() : PeopleBuilder 객체 반환
		 * PeopleBuilder : People 객체 생성해주는 객체
		 * 	- 변수 관련된 메소드들 자동 생성해서 제공
		 * 	- 선별해서 데이터 초기화(값 대입) 가능한 기능
		 * 
		 * name("KBJ") : name 변수에 종속적으로 값 대입되는 메소드
		 * build() : 실제 해당 객체 생성해주는 메소드
		 */
		People p = People.builder().name("KBJ").build();
		System.out.println(p.name + " " +p.age);//KBJ 0(age는 값 지정하지 않아서 기본값)
		System.out.println(p);//People(name=KBJ, age=0)
		
	}
}