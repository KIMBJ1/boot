package step02.junittest;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class Junit02Assertion {

//	@Test
	public void assertTest() {
		// 1. junit이라는 데이터에 대한 확인 로직
		assertEquals("junit2", "junit");
		System.out.println("------- junit인 경우에만 실행되는 라인");
	}

//	@Test
	public void assertTest2() {
		// 1. null 대한 확인 로직
		assertNull("junit2", null); // 첫번째 parameter가 null이 아니면 다음 로직들 다 무시
		System.out.println("------- null인 경우에만 실행되는 라인");
	}

//	@Test
	public void assertTest3() {
		// 1. null 대한 확인 로직
		assertNull(null);
		System.out.println("------- null인 경우에만 실행되는 라인");
	}

//	@Test
	public void assertTest4() {
		// 1. null 대한 확인 로직
		assertTrue(true);
		System.out.println("------- true인 경우에만 실행되는 라인");
	}

	// parameter가 있는 method 단위 test 하기
	// 이 메소드 호출하는 다른 개발자는 test시에 반드시 2라는 값만 parameter로 유입되어야 하는 상황
	// step01
	public void assertTest5(int v) {
		// if(v == 2){} : client가 유입시키는 데이터값이 맞? 틀?
		assertTrue(v == 2); // 개발자들간의 코드 검증
		System.out.println("v == 2 : " + v);
	}

//	@Test
	public void asserTest5test() {
		assertTest5(2);
	}

	//단위 test만으로 parameter 적용
	//다양한 int값들 적용도 시도
//	@ParameterizedTest
//	@ValueSource(ints = {1, 2, 3}) //JUnit에서 1,3은 단위테스트 실패 / 2는 단위테스트 성공
	public void assertTest6(int v) {
		assertTrue(v == 2);
		System.out.println("v = 2");
	}
	
	/* CSV는 몇 가지 필드를 쉼표(, )로 구분한 텍스트 데이터 및 텍스트 파일이다.
	 * 확장자는 .csv이며 MIME 형식은 text/csv이다. comma-separated variables라고도 한다
	 * 
	 */
	@ParameterizedTest
	@CsvSource(value = {"2001,Asdf", "1995,asdf"})
	public void assertTest7(int age, String name) {
		assertTrue(age == 1995 && name.equals("asdf")); //반드시 age = 1995 / name = "asdf"
		System.out.println("name : asdf, age = 1995");
	}
}
