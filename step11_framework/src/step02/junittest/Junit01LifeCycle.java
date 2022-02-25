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
		System.out.println("@BeforeAll : ��� Test�� �� �ѹ��� ���ʷ� ����");
	}
	
	@BeforeEach
	public void beforeEach() {
		System.out.println("@BeforeEach : test ������ ������ test ���� ����");
	}
	
	@AfterEach
	public void afterEach() {
		System.out.println("@AfterEach : test ������ ������ test ���� ��");
	}
	
	@AfterAll
	public static void afterAll() {
		System.out.println("@AfterAll : ��� test ���� �� �� �ѹ��� ����");
	}
	
	@Test
	public void test() {
		System.out.println("@Test : test�ø��� ����");
	}
	
	@Test
	@DisplayName("test2 �޼ҵ�� ��� ��µǴ� ǥ������")  
	public void test2() {
		System.out.println("@Test 2");
	}
	
	
}
