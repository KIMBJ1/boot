/* Employee CRUD 로직
 * 
 * 1. ArrayList는 멤버 변수 선언? / 각 메소드별 로컬 변수 선언?
 * 	- 4개의 메소드가 공유하는 자원(data)
 * 	- 멤버 변수 : 모든 메소드가 공유 -----------------------------이걸로 함
 * 			  : 공유하는 자원이기 때문에 멤버변수로 함
 * 	- rdbms에서 select한다고 가정
 * 		- 데이터를 초기화하는 로직
 * 			static{}
 * 	- 로컬 변수 : 선언된 메소드 내에서만 사용
 * 		***선언된 변수가 가장 근접한 {}내에서만 사용됨
 * 2. 사원 한 명 검색시 기준 데이터
 * 3. 사원 한 명 갱신 기준 데이터? 어떤 데이터 수정  --- 이거는 부서번호
 * 4. 삭제 시 어떤 데이터 기준으로?
 */
package step01.test;

import java.util.ArrayList;

import exception.idInvalidateException;
import model.domain.Employee;

public class ListTest2 {
	//private static인 이유 : private은 객체 생성해야만 사용 가능한 변수라서 static{}내부에서 호출 불가
	private static ArrayList<Employee> al = new ArrayList<>();
	
	//static{} : 객체 생성 시점과 무관하게 ListTest2.class 로딩시 자동 실행
	//
	static {
		al.add(new Employee("1", "asdf", 11)); //0번째 저장
		al.add(new Employee("2", "qwer", 22)); //1번쨰 저장
	}
	
	//create() - Employee 객체들 ArrayList 저장
//	//방법 1
//	public static void create() {
//		al.add(new Employee("3","zxcv",33));
//	}
//	//방법2
//	public static void create(String empno, String ename, int deptno) {
//		al.add(new Employee(empno, ename, deptno));
//	}
	//방법3 ------------------------------------------------------- 이걸로 함
	//객체 지향이란 이런거다 객체를 제대로 활용하는 코드
	/* 로직 구현시 고려 사항
	 * 경우의 수 1 - 기존에 없는 id 즉 정상 저장 가능
	 * 경우의 수 2 - 이미 있는 id(중복) : 개발자들이 개발한 exception 클래스로 예외 상황 처리
	 * 	idInvalidateException.java로 만들기
	 */
	
	//논리적으로 미존재하는 사번인 경우에만 add할수 있게 코드 구성
	public static void create(Employee newEmp) throws idInvalidateException {
		for(Employee e:al) {
			if(e.getEmpno().equals(newEmp.getEmpno())) { //ArrayList에 이미 있으면 예외 발생
				throw new idInvalidateException("사번 중복");
			}else { //ArrayList에 없으면 저장
			}
		}
		//이 라인이 실행되는 경우는 ArrayListdp wndqhrehls tkqjsdl djqtdmfEoaks tlfgod
		al.add(newEmp);
		}
	//read() - 사원 한명의 사번 검색
	/* 로직
	 * ArrayList의 모든 객체들의 사번을 비교 (조건식, 직원이 여러명이니까 반복문 필요?)
	 * if 검색 요청한 사번 존재
	 * 	Employee 객체 반환
	 * if 검색 요청한 사번 정보 없음
	 * 	null 반환
	 * 	
	 * String 클래스에 boolean equals(Object anObject){String객체값 비교해서 반환}
	 */
	public static Employee read(String empno){//직원 고유 정보 : 사번
		Employee emp = null; //로컬 변수들은 선언시 기본값으로 초기화 권장
		/* e.getEmpno().equals(empno)
		 * e - Employee
		 * e.getEmpno() - String
		 * 		public String getEmpno(){}
		 * e.getEmpno().equals(...) - boolean
		 * 		public boolean equals (Object anObject){}
		 */
		for(Employee e:al) {
			if(e.getEmpno().equals(empno)) { //if(true) or if(false)
				return e;
			}
		}
		return null; //if 문장 false일 경우여도 반환은 필수이니까 필요한 코드
		 
	}
	//update() - 사원 한명의 부서번호 갱신
	/* 필요 데이터 : 사번과 수정하고자 하는 갱신된 부서 번호
	 * if 없는 사원번호
	 * if 없는 부서번호
	 * 	if 사원번호도 틀려
	 * 	if 사원번호는 맞아
	 */
	public static boolean update(String empno, int newDept) {
		for(Employee e:al) {
			if(e.getEmpno().equals(empno)) { 
				//사원번호가 true경우 부서번호 변경
				e.setDeptno(newDept);
				return true;
			}
		}
		return false;
	}
	//delete() - 존재하는 사원 한명 삭제
	//remove() - ArrayList 내부에 해당 사번의 사원 삭제
	public static boolean delete(String empno){
		for(Employee e:al) {
			if(e.getEmpno().equals(empno)) { 
				al.remove(e);		
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println("-------0. 기존 직원");
		System.out.println(al);
		System.out.println();
		System.out.println("-------1. 새로운 직원 입사");
		System.out.println("미존재하는 사원 저장");
		try {
			create(new Employee("0", "zxcv", 00));
			System.out.println("정상 저장");
			//사원 번호 중복 저장
			create(new Employee("0", "zxcv", 00));
		}catch(idInvalidateException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(al);
		System.out.println();
		System.out.println("-------2. 모든 직원 검색");
		System.out.println(al);
		System.out.println();
		System.out.println("-------3. 사원 한 명 검색 : empno없으면 null(null값 숨기기)");
		//null 키워드는 절대 서비스시에 end user(사용자)에게 오픈 불가
		Employee e = read("3");
		if(e != null) {
			System.out.println(e);
		}else {
			System.out.println("해당 사번 미 존재");
		}
		e = read("9");
		if(e != null) {
			System.out.println(e);
		}else {
			System.out.println("해당 사번 미 존재");
		}
		
		System.out.println();
		System.out.println("-------4. 사원 한 명 부서번호 갱신");
		update("1", 9);
		System.out.println(al);
		System.out.println();
		System.out.println("-------5. 사원 삭제 후 검색");
		delete("1");
		System.out.println(al);
		boolean result = delete("2");
		if(result) {
			System.out.println("퇴사");
			System.out.println(al);
		}else {
			System.out.println("해당 사번 미 존재");
		}
	}

}
