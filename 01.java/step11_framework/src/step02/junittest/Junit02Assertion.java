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
		// 1. junit�̶�� �����Ϳ� ���� Ȯ�� ����
		assertEquals("junit2", "junit");
		System.out.println("------- junit�� ��쿡�� ����Ǵ� ����");
	}

//	@Test
	public void assertTest2() {
		// 1. null ���� Ȯ�� ����
		assertNull("junit2", null); // ù��° parameter�� null�� �ƴϸ� ���� ������ �� ����
		System.out.println("------- null�� ��쿡�� ����Ǵ� ����");
	}

//	@Test
	public void assertTest3() {
		// 1. null ���� Ȯ�� ����
		assertNull(null);
		System.out.println("------- null�� ��쿡�� ����Ǵ� ����");
	}

//	@Test
	public void assertTest4() {
		// 1. null ���� Ȯ�� ����
		assertTrue(true);
		System.out.println("------- true�� ��쿡�� ����Ǵ� ����");
	}

	// parameter�� �ִ� method ���� test �ϱ�
	// �� �޼ҵ� ȣ���ϴ� �ٸ� �����ڴ� test�ÿ� �ݵ�� 2��� ���� parameter�� ���ԵǾ�� �ϴ� ��Ȳ
	// step01
	public void assertTest5(int v) {
		// if(v == 2){} : client�� ���Խ�Ű�� �����Ͱ��� ��? Ʋ?
		assertTrue(v == 2); // �����ڵ鰣�� �ڵ� ����
		System.out.println("v == 2 : " + v);
	}

//	@Test
	public void asserTest5test() {
		assertTest5(2);
	}

	//���� test������ parameter ����
	//�پ��� int���� ���뵵 �õ�
//	@ParameterizedTest
//	@ValueSource(ints = {1, 2, 3}) //JUnit���� 1,3�� �����׽�Ʈ ���� / 2�� �����׽�Ʈ ����
	public void assertTest6(int v) {
		assertTrue(v == 2);
		System.out.println("v = 2");
	}
	
	/* CSV�� �� ���� �ʵ带 ��ǥ(, )�� ������ �ؽ�Ʈ ������ �� �ؽ�Ʈ �����̴�.
	 * Ȯ���ڴ� .csv�̸� MIME ������ text/csv�̴�. comma-separated variables��� �Ѵ�
	 * 
	 */
	@ParameterizedTest
	@CsvSource(value = {"2001,Asdf", "1995,asdf"})
	public void assertTest7(int age, String name) {
		assertTrue(age == 1995 && name.equals("asdf")); //�ݵ�� age = 1995 / name = "asdf"
		System.out.println("name : asdf, age = 1995");
	}
}
