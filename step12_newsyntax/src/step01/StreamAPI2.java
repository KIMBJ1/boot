/* �н�����
 * 
 * Optional API
 * 1. list/map/setó�� ������ ���� ����
 * 
 * 2. �ʿ伺
 * 	- ����� �߻������� �����߿� NullPointerException
 * 		- java.lang.RuntimeException�� ����
 * 		- try~catch ���� ��, ����ÿ��� �߰�
 * 	- NullPointerException �߻����� �ʰ� �������� ����ó�� ���� �����ϰ� �ϴ� ���
 * 
 * 3. 
 */

package step01;

import java.util.Optional;

import org.junit.jupiter.api.Test;

public class StreamAPI2 {

	//Optional API ������� ����
//	@Test
	public void m1() {
		String v = null;
		System.out.println(v.length()); //NullPointerException �߻�
		System.out.println("���� ����"); //���� �߻����� ���� �Ұ�
	}
	/* null ó���� API
	 * ofNullable()
	 * 1. Optional ��ü ���� �޼ҵ�
	 * 	1. parameter��
	 * 		1. null�̸� : Optional.empty
	 * 		2. ��ü�̸� : Optional[��ü] ����
	 * 2. .isPresent() : Optional ��ü ���� ����� ��ü ���� ���� Ȯ�� �޼ҵ�
	 * 	- empty : false
	 * 	- not empty : true
	 * 
	 * 3. ifPresent() : if ���ǽİ� ���� ���
	 * 	- empty : null�ǹ�, NullPointerException �߻� ����, ���� ���� skip
	 * 	- not empty : ���� ����
	 * 
	 */
	//Optional API ���
//	@Test
	public void m2() {
		String v = null;
		Optional<String> opt = Optional.ofNullable(v);
		Optional<String> opt2 = Optional.ofNullable("asdf");
		
		System.out.println(opt); //Optional.empty
		System.out.println(opt2); //Optional[string]
		
		System.out.println(opt.isPresent()); //false / null�̸� false
		System.out.println(opt2.isPresent()); //true
		
		//null���ο� �����ϰ� ���� ����
//		opt.ifPresent(data); //opt�� ���� �����Ͱ��� data�� ����
		opt.ifPresent((data) -> {System.out.println(v.length());}); //data�� null�̸� {}���� skip
		
//		System.out.println(v.length());
		System.out.println("���� ����");
		
	}
	
	/* 1. of() : null ����
	 * 	- null Optional ��ü ���� �� NullPointerException �߻�
	 * 2. of() ���ÿ��� ifPresent() �ʿ� ����
	 * 
	 */
//	@Test
	public void m3() {
		String v = null;
		
		//�̰Ŵ� junit ������
		//of() : null�� ��� NullPointerException �߻�
//		Optional<String> opt = Optional.of(v);
		Optional<String> opt = Optional.of("v");
		Optional<String> opt2 = Optional.of("asdf");
		System.out.println(opt);
		System.out.println(opt2);
		System.out.println(opt.isPresent());
		System.out.println(opt2.isPresent());
//		System.out.println(v.length());
		System.out.println("���� ����");
	}
	/* orElse()
	 * - null�� ��츦 ����ؼ� �����ϰ��� �ϴ� ������ ���� ��� ����
	 * - null�� ���� orElse() �޼ҵ� parameter ��ȯ
	 * - null�� �ƴ� ���� Optional ��ü�� ������ ��ü�� ���밪�� ���
	 * 
	 */
	@Test
	public void m4() {
		String v = null;
		
		Optional<String> opt = Optional.ofNullable(null);
		System.out.println(opt.orElse("null�� ��� ����"));
		Optional<String> opt2 = Optional.ofNullable("asdf");
		System.out.println(opt2.orElse("null�� ��� ����"));
		
		System.out.println(v.length());
		System.out.println("���� ����");
	}

}
