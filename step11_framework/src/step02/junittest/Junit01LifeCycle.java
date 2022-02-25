package step02.junittest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Junit01LifeCycle {
	@BeforeAll
	public static void beforeAll() {
		System.out.println("@BeforeAll : 모든 Test전 단 한번만 최초로 실행");
	}
	
	@BeforeEach
	public void beforeEach() {
		System.out.println("@BeforeEach : test 실행할 때마다 test 전에 실행");
	}
	
	@AfterEach
	public void afterEach() {
		System.out.println("@AfterEach : test 실행할 때마다 test 실행 후");
	}
	
	@AfterAll
	public static void afterAll() {
		System.out.println("@AfterAll : 모든 test 실행 후 단 한번만 실행");
	}
	
	@Test
	public void test() {
		System.out.println("@Test : test시마다 실행");
	}
	
	@Test
	@DisplayName("test2 메소드명 대신 출력되는 표현문구")  
	public void test2() {
		System.out.println("@Test 2");
	}
	
	
}
