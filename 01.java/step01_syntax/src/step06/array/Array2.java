package step06.array;

import step02.Person;

public class Array2 {

	// Person값들로 배열 생성 및 반환
	public static Person[] getPersonArray() {
		Person p1 = Person.builder().name("김이름").age(1995).build();
		Person p2 = Person.builder().name("김이박").age(2001).build();
		
		Person[] i = {p1, p2};
		return i;
	}

	// Person값들로 구성된 배열 받아서 출력
	// 단순 돌리기
	public static void printArray(Person[] v) {
		System.out.println("------- 단순 노가다 돌리기");
		System.out.println(v[0]);
		System.out.println(v[1]);
	}
	// 반복문 추가 학습
	public static void printArrayFor1(Person[] v) {
		for(int i = 0; i <= 1; i++) {
			System.out.println(v[i]);
		}

	}
	//length : 생성된 배열에 자동 추가되는 변수(배열 크기값 보유)
	//alt shift r로 변수 수정하면 관련 변수 다 바뀜************************************
	public static void printArrayFor2(Person[] v) {
		for(int i = 0; i < v.length; i++) {
			System.out.println(v[i]);
		}

	}
	
	//배열, List 객체들에게 사용되는 반복문
	public static void printArrayForEach(Person[] v) {
		for(Person i : v) {
			System.out.println(i.getName());
		}

	}

	public static void printArrayWhile(Person[] v) {
		int i = 0;
		while(i < v.length) {
			System.out.println(v[i].getAge());
			i++;
		}

	}

	public static void main(String[] args) {
		Person[] v1 = getPersonArray();
		printArray(v1);
		System.out.println("------- for문 돌리기");
		printArrayFor1(v1);
		System.out.println("------- for문 length로 돌리기");
		printArrayFor2(v1);
		System.out.println("------- ForEach문 돌리기");
		printArrayForEach(v1);
		System.out.println("------- while문 돌리기");
		printArrayWhile(v1);

	}

}
