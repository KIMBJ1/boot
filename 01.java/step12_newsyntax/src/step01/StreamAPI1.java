package step01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import model.domain.People;

public class StreamAPI1 {
	// step01 - double colon ������ ::
	public static void m1() {
		People p1 = new People("asdf", 1995);
		People p2 = new People("zxcv", 2001);
		People p3 = new People("qwer", 2020);
		// List<People> ��ȯ
		Arrays.asList(p1, p2, p3).forEach(System.out::println);

		System.out.println("------- for������ ������");
		List<People> datas = Arrays.asList(p1, p2, p3);
		for (People p : datas) {
			System.out.println(p);
		}

	}

	public static void m2() {

		// step02 - stream api(-> ���ٽ� Ȱ��)
		ArrayList<Integer> all = new ArrayList<Integer>();
		all.add(7); // new Integer(3) ����ڽ�
		all.add(5);
		all.add(1);
		all.add(8);
		
		//stream ��ü�� ��ȯ
		//filter(v��� ������ ���� -> 7 ������ �����͸� ����
		//filter �޼ҵ� ��ȯ���� String Ÿ�� ���� ���ꤤ�� ���� mapToInt() ȣ���ؼ� int�� ��ȯ
		//int��ȯ
		//��
		int r = all.stream().filter(v -> v <= 7).mapToInt(i -> i).sum();
		System.out.println(r);
		
		System.out.println("------- 70�� �̻� ���� ���");
		List<Integer> datas = Arrays.asList(50,70,40,50,80,90,100,70,80,40);
		Arrays.asList(50,70,40,50,80,90,100,70,80,40).stream().filter(v -> v >=70).forEach(System.out::println);
		System.out.println("------- �߰�");
		System.out.println(all.stream().filter(v -> v <= 7).mapToInt(i -> i).count());
		System.out.println(all.stream().filter(v -> v <= 7).mapToInt(i -> i).max()); //7���� ������ Optional ��ü
		System.out.println(all.stream().filter(v -> v <= 7).mapToInt(i -> i).max().getAsInt()); //Optional ��ü�� ���빰 ��ȯ

		System.out.println();
		Arrays.asList(0,1,2,3,4,5,6,7,8,9).stream().skip(2).forEach(System.out::println);
	}
	
	public static void m3() {
		// Stream �ֿ� API
		System.out.println("------- forEach : �ݺ�");
		Arrays.asList(1,2,3,4).stream().forEach(System.out::println);
		System.out.println("------- map : ����Ʈ�� �ִ� ����� ���� ���� �� ���");
		Arrays.asList(1,2,3,4).stream().map(i -> i*i).forEach(System.out::println);
		System.out.println("------- skip : �ε��� �������� ��� ���� ���ο� stream ���� �� ���");
		Arrays.asList(0,1,2,4).stream().skip(2).forEach(System.out::println);
		System.out.println("limit : ������ �ε��������� ��� ���� �� ���");
		Arrays.asList(1,2,3,4).stream().limit(2).forEach(System.out::println);
		System.out.println("------- filter : stream ���� ��ü �����Ͽ� stream ��ȯ");
		Arrays.asList(Arrays.asList(1,2),Arrays.asList(3,4),Arrays.asList(5,6)).stream().flatMap(i -> i.stream()).forEach(System.out::println);
		System.out.println("------- reduce : stream ���Ͽ�ҷ� ��ȯ");
		System.out.println(Arrays.asList(1,2,3,4).stream().reduce((v1,v2) -> v1 + v2)); //Optional
		System.out.println(Arrays.asList(1,2,3,4).stream().reduce((v1,v2) -> v1 - v2).get());
		System.out.println("------- collect / iterator : �ݷ��� ��ü ����� ��ȯ");
		System.out.println(Arrays.asList(1,2,3,4,5).stream().collect(Collectors.toList()));
		Arrays.asList(1,2,3,4).stream().iterator().forEachRemaining(System.out::println);
	}

	public static void main(String[] args) {
//		m1();
//		m2();
		m3();
	}

}
