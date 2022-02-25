/* 학습내용
 * 
 * Optional API
 * 1. list/map/set처럼 데이터 보유 가능
 * 
 * 2. 필요성
 * 	- 실행시 발생가능한 예외중에 NullPointerException
 * 		- java.lang.RuntimeException의 하위
 * 		- try~catch 없이 즉, 실행시에만 발견
 * 	- NullPointerException 발생되지 않게 안정적인 사전처리 구현 가능하게 하는 기술
 * 
 * 3. 
 */

package step01;

import java.util.Optional;

import org.junit.jupiter.api.Test;

public class StreamAPI2 {

	//Optional API 사용하지 않음
//	@Test
	public void m1() {
		String v = null;
		System.out.println(v.length()); //NullPointerException 발생
		System.out.println("정상 실행"); //예외 발생으로 실행 불가
	}
	/* null 처리용 API
	 * ofNullable()
	 * 1. Optional 객체 생성 메소드
	 * 	1. parameter가
	 * 		1. null이면 : Optional.empty
	 * 		2. 객체이면 : Optional[객체] 생성
	 * 2. .isPresent() : Optional 객체 내에 저장된 객체 존재 여부 확인 메소드
	 * 	- empty : false
	 * 	- not empty : true
	 * 
	 * 3. ifPresent() : if 조건식과 같은 기능
	 * 	- empty : null의미, NullPointerException 발생 안함, 로직 실행 skip
	 * 	- not empty : 정상 실행
	 * 
	 */
	//Optional API 사용
//	@Test
	public void m2() {
		String v = null;
		Optional<String> opt = Optional.ofNullable(v);
		Optional<String> opt2 = Optional.ofNullable("asdf");
		
		System.out.println(opt); //Optional.empty
		System.out.println(opt2); //Optional[string]
		
		System.out.println(opt.isPresent()); //false / null이면 false
		System.out.println(opt2.isPresent()); //true
		
		//null여부와 무관하게 정살 실행
//		opt.ifPresent(data); //opt가 가진 데이터값을 data에 넣음
		opt.ifPresent((data) -> {System.out.println(v.length());}); //data가 null이면 {}로직 skip
		
//		System.out.println(v.length());
		System.out.println("정상 실행");
		
	}
	
	/* 1. of() : null 불허
	 * 	- null Optional 객체 생성 시 NullPointerException 발생
	 * 2. of() 사용시에는 ifPresent() 필요 없음
	 * 
	 */
//	@Test
	public void m3() {
		String v = null;
		
		//이거는 junit 에러남
		//of() : null인 경우 NullPointerException 발생
//		Optional<String> opt = Optional.of(v);
		Optional<String> opt = Optional.of("v");
		Optional<String> opt2 = Optional.of("asdf");
		System.out.println(opt);
		System.out.println(opt2);
		System.out.println(opt.isPresent());
		System.out.println(opt2.isPresent());
//		System.out.println(v.length());
		System.out.println("정상 실행");
	}
	/* orElse()
	 * - null인 경우를 고려해서 실행하고자 하는 로직이 있을 경우 권장
	 * - null인 경우는 orElse() 메소드 parameter 반환
	 * - null이 아닌 경우는 Optional 객체가 보유한 객체의 내용값이 출력
	 * 
	 */
	@Test
	public void m4() {
		String v = null;
		
		Optional<String> opt = Optional.ofNullable(null);
		System.out.println(opt.orElse("null인 경우 실행"));
		Optional<String> opt2 = Optional.ofNullable("asdf");
		System.out.println(opt2.orElse("null인 경우 실행"));
		
		System.out.println(v.length());
		System.out.println("정상 실행");
	}

}
