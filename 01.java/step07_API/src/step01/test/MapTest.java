/* 학습 내용 : Map
 * 1. 고유한 구분자(key)로 값(value) 관리 및 활용하는 궂ㅎ
 * 2. 객체 타입만 활용
 * 3. key는 중복 불허 / value는 중복 가능
 */
package step01.test;

import java.util.ArrayList;
import java.util.HashMap;

import model.domain.Employee;

public class MapTest {

	public static void main(String[] args) {
		HashMap<String, String> maps = new HashMap<String, String>();
		maps.put("a", "asdf");
		maps.put("b", "qwer");
		maps.put("c", "zxcv");
		maps.put("a", "zxcv"); //a라는 key로 이미 존재하는 객체 삭제 후 저장
		System.out.println("------- maps : key 중복 불가 / value 중복 가능");
		//재정의된 toString() 반환값 단순 출력
		System.out.println(maps);
		
		System.out.println("\n------- 고유한 key로 데이터 하나 뽑아서 출력");
		String v = maps.get("a");
		System.out.println("key가 a인 maps의 value : " + v);

		HashMap<String, Employee> maps2 = new HashMap<String, Employee>();
		maps2.put("11", new Employee("11", "charlie", 10));
		maps2.put("22", new Employee("22", "adam", 10));
		System.out.println("\n------- adam"
				+ "이름만 출력하기");
		System.out.println(maps2.get("22").getEname());
		
		System.out.println("\n------- Map에 List 저장 및 활용");
		/* 부서별로 직원 저장(ArrayList) -> 부서를 구분자로 모든 직원 저장(HashMap)
		 * 
		 */
		ArrayList<Employee> emps = new ArrayList<Employee>();
		//다 10번 부서라고 가정
		emps.add(new Employee("11","emp01",10));
		emps.add(new Employee("22","emp02",10));
		emps.add(new Employee("33","emp03",10));
		
		System.out.println(emps);
		
		HashMap<String, ArrayList<Employee>> all = new HashMap<String, ArrayList<Employee>>();
		all.put("개발", emps); //총무부 번호가 10
		System.out.println("\n------- emp03이라는 직원의 이름 출력");
		System.out.println(all.get("개발").get(2).getEname());
		
		System.out.println("\n------- emp02 이름 변경후 출력");
		all.get("개발").get(1).setEname("emp99");
		System.out.println(all.get("개발").get(1).getEname());
	}

}
