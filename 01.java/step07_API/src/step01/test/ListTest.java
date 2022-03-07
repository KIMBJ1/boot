/* list 자료구조 API
 * 1. Object[] 배열과 흡사
 * 2. index로 관리
 * 3. 배열과의 차이점
 * 	- 클래스로 기능이 제공
 * 	- 데이터들을 메소드로 활용
 * 	- 배열은 한번 생성된 크기가 변경 불가
 * 	- list는 동적으로 실시간 메모리 크기가 바뀜
 * 4. 특징 : 객체 타입들만 저장 가능
 * 	- 가령 3이라는 숫자값만 저장하고 싶은 겨우 해결책
 * 		- 기본값들을 객체처럼 표현 가능하게 해주는 8가지 도움 클래스 존재
 * 		- int : Integer(클래스, 참조 타입) / byte : Byte(클래스, 참조 타입) etc...
 * 		- wrapper class들 존재(8가지)
 * 			- 기본 타입을 객체처럼 사용 가능하게 support해주는 클래스
 * 5. 주요 API
 * 	1. 저장 / 활용(반환) / 삭제
 * 		- add(Object) / get(int) / remove(int
 * 	2. 저장된 데이터 개수 확인
 * 		- size()
 * 6. 다른 관점에서의 list
 * 	- 속도
 * 		- 데이터 증가시 메모리 증가 / 데이터 삭제시 삭제된 이후의 데이터 re index
 * 		- 실행 속도 측면에서는 배열보다 느리다
 * 	- 혹여 다수의 데이터들을 실시간 저장, 삭제 시에는 배열보다 권장
 * 	- 삭제하는 데이터가 배열 중간에 포함되어 있다면 비추
 * 	- 삭제하는 데이터들이 마지막 부분에 저장되어 있다면 권장
 */

package step01.test;

import java.util.ArrayList;

import model.domain.CustomerDTO;

public class ListTest {

	//정통 문법 : 객체 타입인 경우 무조건 모두 다 저장
	public static void m1() {
		System.out.println("-------m1");
		//데이터 저장 가능한 메모리 생성
		ArrayList a1 = new ArrayList(); //10개의 메모리 공간을 보유한 객체 생성
		
		//데이터를 2개 저장 - String, Integer타입 서로 연관 없음 / 단 Object 타입
		//public boolean add(Object o){parameter 로 유입된 데이터를 ArrayList에 저장)
		a1.add("문자열0"); //0번째로 저장
		a1.add(new Integer(1)); //a1.add(3); 컴파일 시 a1.add(new Integer(3)) 자동으로 이렇게 바뀜
		a1.add("문자열2");
		a1.add(3);
		//저장된 데이터 개수 확인 - 메모리 개수 확인 아님
		//단순 확인
		System.out.println(a1); //a1.toString() 재정의 : 보유된 모든 데이터값 하나의 문자열로 반환
		System.out.println(a1.size()); //데이터 개수

		//index 2번째의 문자열2 삭제 후 size() 호출
		a1.remove(2);
		System.out.println(a1);
		System.out.println(a1.size());
	}
	
	//저장(add) 활용(get)
	/* public boolean add(Obect o){}
	 * public Object remove(int index){}
	 * public Object get(int index){해당 index의 저장되어 있는 데이터 반환}
	 */
	public static void m2() {
		System.out.println();
		System.out.println();
		System.out.println("-------m2");
		//초기 생성되는 메모리 개수 + 증가치 메모리 개수
		ArrayList al = new ArrayList(5); //5개의 메모리 생성
		al.add("1");
		al.add("2");
		al.add("3");
		System.out.println(al);
		System.out.println("a1 리스트 사이즈 : " + al.size());
		al.add("4");
		al.add("5");
		System.out.println(al);
		System.out.println("a1 리스트 사이즈 : " + al.size());
		//5개 넘어가는 메모리 필요시 6번 데이터 저장하면서 메모리 5개씩 증가
		al.add("6");
		System.out.println(al);
		System.out.println("a1 리스트 사이즈 : " + al.size());
		al.add("7");
		al.add("8");
		System.out.println(al);
		System.out.println("a1 리스트 사이즈 : " + al.size());
		System.out.println("원래 a1 리스트 : " + al);
		System.out.println(al.get(2)); //3
		al.remove(2); //해당 index 삭제 하면서 뒤에 저장되어 있던 데이터를 index 재정렬
		System.out.println("index2 삭제 a1 리스트 : " + al);
		System.out.println(al.get(2)); //4
	}
	
	public static void m3() {
		System.out.println();
		System.out.println("-------m3");
		ArrayList al = new ArrayList(); //5개의 메모리 생성
		al.add("1");
		al.add("2");
		al.add("3");
		
		System.out.println(al);
		String s = (String)al.get(1);
		System.out.println(s);
		System.out.println(s.charAt(0));
		System.out.println(al.size());

	}
	
	//타입을 제한할 수 있는 jdk1.5부터 제시된 제네릭 문법
	//향후 개발시에는 자료구조 API로 데이터 관리시에 대부분 동일한 데이터 관리
	public static void m4() {
		System.out.println();
		System.out.println("-------m4");
		//String만 저장 가능한 동적 배열 구조 생성
		//String[]로 간주 단 메모리 크기 제한 없음
		ArrayList<String> a1 = new ArrayList<String>(); //5개의 메모리 생성
		a1.add("a");
		a1.add("s");
		a1.add("d");
		a1.add("f");
		System.out.println(a1);

		String s = a1.get(2);
		System.out.println(s.charAt(0));
		System.out.println(s);
		
	}
	
	//고객의 모든 정보를 관리자 화면에 출력 위해 db로부터 select -> CustomerDTO 객체 생성 -> ArrayList저장 -> 반환
	public static ArrayList<CustomerDTO> getCustomerDTOs(){
		
		ArrayList<CustomerDTO> all = new ArrayList<CustomerDTO>();
		
		all.add(new CustomerDTO("u1", 11)); //0번째 저장
		all.add(new CustomerDTO("u2", 22));
		
		return all;
	}

	public static ArrayList nonGetCustomers(){
		
		ArrayList all = new ArrayList();//10개 메모리 생성
		
		all.add(new CustomerDTO("u1", 11));  //0번째 저장
		all.add(new CustomerDTO("u2", 22));  //1번째 저장
		
		return all;
	}
	public static void main(String[] args) {
		m1();
		m2();
		m3();
		m4();
		
		ArrayList<CustomerDTO> all = getCustomerDTOs();
		
		// u2만 출력
		/* all.get(1);
		 * all : ArrayList<CustomerDTO>
		 * all.get(1) : CustomerDTO (id, pw 두 개의 데이터를 보유하는 객체
		 */
		System.out.println();
		System.out.println("-------CustomerDTO 제네릭");
		System.out.println(all.get(0));
		System.out.println(all.get(0).getId());
		
		System.out.println("-------CustomerDTO non 제네릭");
		ArrayList a = nonGetCustomers();
		System.out.println(((CustomerDTO)a.get(1)));
		System.out.println(((CustomerDTO)a.get(1)).getId());
	}

}
