package step06.array;

public class Array1 {

	// int값들로 배열 생성 및 반환
	public static int[] getIntArray() {
		int[] i = { 1, 2, 3 }; // int배열 타입의 변수
		return i;
	}

	// int값들로 구성된 배열 받아서 출력
	// 단순 돌리기
	public static void printArray(int[] v) {
		System.out.println("------- 단순 노가다 돌리기");
		System.out.println(v[0]);
		System.out.println(v[1]);
		System.out.println(v[2]);
	}
	// 반복문 추가 학습
	public static void printArrayFor1(int[] v) {
		for(int i = 0; i <= 2; i++) {
			System.out.println(v[i]);
		}

	}
	//length : 생성된 배열에 자동 추가되는 변수(배열 크기값 보유)
	//alt shift r로 변수 수정하면 관련 변수 다 바뀜************************************
	public static void printArrayFor2(int[] v) {
		for(int i = 0; i < v.length; i++) {
			System.out.println(v[i]);
		}

	}
	
	//배열, List 객체들에게 사용되는 반복문
	public static void printArrayForEach(int[] v) {
		for(int i : v) {
			System.out.println(i);
		}

	}

	public static void printArrayWhile(int[] v) {
		int i = 0;
		while(i <= 2) {
			System.out.println(v[i]);
			i++;
		}

	}

	public static void main(String[] args) {
		int[] v1 = getIntArray();
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
