package step01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import model.domain.People;

public class StreamAPI1 {
	// step01 - double colon 연산자 ::
	public static void m1() {
		People p1 = new People("asdf", 1995);
		People p2 = new People("zxcv", 2001);
		People p3 = new People("qwer", 2020);
		// List<People> 반환
		Arrays.asList(p1, p2, p3).forEach(System.out::println);

		System.out.println("------- for문으로 돌리기");
		List<People> datas = Arrays.asList(p1, p2, p3);
		for (People p : datas) {
			System.out.println(p);
		}

	}

	public static void m2() {

		// step02 - stream api(-> 람다식 활용)
		ArrayList<Integer> all = new ArrayList<Integer>();
		all.add(7); // new Integer(3) 오토박싱
		all.add(5);
		all.add(1);
		all.add(8);
		
		//stream 객체로 변환
		//filter(v라는 변수에 담음 -> 7 이하인 데이터만 정제
		//filter 메소드 반환값은 String 타입 따라서 연산ㄴ을 위해 mapToInt() 호출해서 int로 변환
		//int변환
		//합
		int r = all.stream().filter(v -> v <= 7).mapToInt(i -> i).sum();
		System.out.println(r);
		
		System.out.println("------- 70점 이상 점수 출력");
		List<Integer> datas = Arrays.asList(50,70,40,50,80,90,100,70,80,40);
		Arrays.asList(50,70,40,50,80,90,100,70,80,40).stream().filter(v -> v >=70).forEach(System.out::println);
		System.out.println("------- 추가");
		System.out.println(all.stream().filter(v -> v <= 7).mapToInt(i -> i).count());
		System.out.println(all.stream().filter(v -> v <= 7).mapToInt(i -> i).max()); //7값을 보유한 Optional 객체
		System.out.println(all.stream().filter(v -> v <= 7).mapToInt(i -> i).max().getAsInt()); //Optional 객체의 내용물 반환

		System.out.println();
		Arrays.asList(0,1,2,3,4,5,6,7,8,9).stream().skip(2).forEach(System.out::println);
	}
	
	public static void m3() {
		// Stream 주요 API
		System.out.println("------- forEach : 반복");
		Arrays.asList(1,2,3,4).stream().forEach(System.out::println);
		System.out.println("------- map : 리스트에 있는 요소의 제곱 연산 및 출력");
		Arrays.asList(1,2,3,4).stream().map(i -> i*i).forEach(System.out::println);
		System.out.println("------- skip : 인덱스 이전까지 요소 제외 새로운 stream 생성 및 출력");
		Arrays.asList(0,1,2,4).stream().skip(2).forEach(System.out::println);
		System.out.println("limit : 선언한 인덱스까지의 요소 추출 및 출력");
		Arrays.asList(1,2,3,4).stream().limit(2).forEach(System.out::println);
		System.out.println("------- filter : stream 내부 객체 연결하여 stream 반환");
		Arrays.asList(Arrays.asList(1,2),Arrays.asList(3,4),Arrays.asList(5,6)).stream().flatMap(i -> i.stream()).forEach(System.out::println);
		System.out.println("------- reduce : stream 단일요소로 반환");
		System.out.println(Arrays.asList(1,2,3,4).stream().reduce((v1,v2) -> v1 + v2)); //Optional
		System.out.println(Arrays.asList(1,2,3,4).stream().reduce((v1,v2) -> v1 - v2).get());
		System.out.println("------- collect / iterator : 콜렉션 객체 만들어 반환");
		System.out.println(Arrays.asList(1,2,3,4,5).stream().collect(Collectors.toList()));
		Arrays.asList(1,2,3,4).stream().iterator().forEachRemaining(System.out::println);
	}

	public static void main(String[] args) {
//		m1();
//		m2();
		m3();
	}

}
