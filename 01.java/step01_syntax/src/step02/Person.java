/*
 * �����ϰ� ��� ������ ���� �� ���� �� ��� ������ ���� Ŭ����
 * this : name = name �Ұ�
 * ���ú��� = ��� ������ ��� ��� ������ �����ϴ� Ű����
 * 	�� �ڱ� �ڽ��� ��ü�� �����ϴ� Ư���� Ű����
 */

package step02;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //@data�� ctrl shift o / @Data�� ctrl space�ʹ� �ٸ��ǰ�?
//@NoArgsConstructor
@Builder //outline�� PersonBuilder ����
public class Person {
	private String name;
	private int age;
	
}
