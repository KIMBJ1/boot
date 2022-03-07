/* ArrayList에 저장 가능한 데이터들 타입
 * - 객체 타입 모두 다 허용
 * - java.lang.Object 하위 타입들 다 저장 가능
 * - java.util.ArrayList도 참조(객체, 클래스) 타입
 * - ArrayList에 ArrayList 저장 가능
 * 
 *  ex)
 * -부서별로 ArrayList에 저장
 * 	: 부서가 10개라면 10개의 ArrayLust
 * - 모든 직원들 정보도 ArrayList로 관리
 * 	: 하나의 ArrayList에 10개의 부서별 ArrayList 저장
 */
package step01.test;

import java.util.ArrayList;

import model.domain.Employee;

public class ReviewTest {
	
	/* Employee 객체 3개를 저장한 ArrayList를 ArrayList에 저장
	 * 
	 */
	static void m1() {
		//step07_API\model.domain\Employee.java 사용
		ArrayList<Employee> emps = new ArrayList<Employee>();
		//ArrayList<Employee>를 저장할수 있는 ArrayList
		ArrayList<ArrayList<Employee>> all = new ArrayList<ArrayList<Employee>>();
		
		emps.add(new Employee("11","emp01",10));
		emps.add(new Employee("22","emp02",22));
		emps.add(new Employee("33","emp03",33));
		
		all.add(emps); //0번째 저장임
		
		System.out.println("------- 1번째 저장된 직원 정보 출력");
		ArrayList<Employee> v1 = all.get(0);
		Employee v2 = v1.get(1); //empno, ename, deptno를 가지고 있음
		System.out.println(v2);
		System.out.println(v1.get(1));
		System.out.println(emps.get(1));
		System.out.println();
		System.out.println("------- v2로 부서번호 수정해도 ㅇㅋ");
		v2.setDeptno(200);
		System.out.println(all.get(0).get(1).getDeptno());
	}
	
	static void m2() {
		ArrayList<Employee> emps = new ArrayList<Employee>();
		ArrayList<ArrayList<Employee>> all = new ArrayList<ArrayList<Employee>>();
		
		emps.add(new Employee("11","emp01",10));
		emps.add(new Employee("22","emp02",22));
		emps.add(new Employee("33","emp03",33));
		
		all.add(emps);
		
		all.get(0).get(1).setDeptno(200);; //empno, ename, deptno를 가지고 있음
		System.out.println("\n------- m1 코드 줄이기");
		System.out.println(all.get(0).get(1).getDeptno());
		/* System : class
		 * out : System내에 static으로 선언된 변수
		 * println() :
		 * out.println() 즉 out 변수 타입인 PrintStream 클래스에서 제공하는 메소드
		 */
		System.out.println("\n------- emp03 -> asdff로 바꾸기");
		System.out.println(all.get(0).get(2));
		System.out.println(all.get(0).get(2).getEname());
		all.get(0).get(2).setEname("asdff");
		System.out.println(all.get(0).get(2));
		System.out.println(all.get(0).get(2).getEname());
		
	}

	public static void main(String[] args) {
		m1();
		m2();

	}

}
