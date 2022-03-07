
/* 학습내용 -Set
 * 1. 데이터들 중복 불허
 * 2. 저장 순서에 대한 보장 없음
 * 3. 데이터 하나하나 구분할수 있는 고유 index 없음
 * 4. API를 보면 데이터 하나씩 반환 메소드 없음
 * 	- Iterator API 활용해서 하나씩 반환
 * 		- boolean hasNest() : 데이터 확인
 * 		- Object next() : 데이터 하나 반환
 * 
 */

package step01.test;

import java.util.HashSet;
import java.util.Iterator;

public class SetTest {

	public static void main(String[] args) {
		System.out.println("------- HashSet 사용해서 중복제거");
		HashSet<String> set = new HashSet<String>();
		set.add("a");
		set.add("b");
		set.add("c");
		set.add("d");
		set.add("d"); //기존에 이미 있으면 기존거 삭제 후 이 데이터 저장
		set.add("c"); //기존 c 삭제후 이 c 저장
		System.out.println(set);
		
		//set 내부의 데이터값들을 하나씩 차출 가능하게 해주는 객체
		Iterator<String> all = set.iterator();
		/* hasNext() : 존재 여부 확인 메소드
		 * next() : 데이터 차출(메모리에서 꺼냄 -즉, 한번만 사용 가능한 객체)
		 */
		
		System.out.println("\n------- hasNext() &nd next()");
		while(all.hasNext()){
			System.out.println(all.next());
		}
		
		
		System.out.println("\n------- 형변환 없이 String만의 멤버 호출 가능");
		Iterator<String> all2 = set.iterator();
		String v = null;
		while(all2.hasNext()){
			v = all2.next();
			System.out.println(v.charAt(0));
		}
		
		System.out.println("\n------- 제네릭 미반영 구조의 코드로 구현하지 말 것");
		System.out.println("------- 제네릭은 all 변수 선언처럼 유지하면서 활용하는 코드 권장"
				+ "");
		
		HashSet<String> set2 = new HashSet<String>();
		set2.add("a");
		set2.add("b");
		set2.add("c");
		set2.add("d");
		set2.add("d");
		
		Iterator all22 = set2.iterator();
		
		while(all22.hasNext()){
			System.out.println(((String)all22.next()).charAt(0));
		}
	}

}
