package view;

import org.junit.Test;

import controller.FoodController;

public class StartView {
	
	
	public static void putFood() {
		System.out.println("*** 초기 DB ***");
		FoodController.foodReadAll();
		System.out.println();
		
		
		System.out.println("*** 1. Create 결과 ***");
		FoodController.foodCreate("05a", "팥빙수", "디저트", 5000);
		FoodController.foodCreate("06a", "마라탕", "중식", 9000);
		FoodController.foodCreate("07a", "짜장면", "중식", 5000);
		FoodController.foodReadAll();
		System.out.println();
	}
	
	
	
	public static void getFood() {		
		System.out.println("*** 2. Read 결과 ***");
		System.out.println("초밥 가격 검색 : ");
		FoodController.foodRead("초밥");
		
		System.out.println("팥빙수 가격 검색 : ");
		FoodController.foodRead("팥빙수");
		
		System.out.println();
		
	}
	
	
	public static void changePrice() {		
		System.out.println("*** 3. Update 결과 ***");
		System.out.println("초밥 가격 변경 (12000 -> 14000) : ");
		FoodController.foodUpdate("초밥", 14000);
		FoodController.foodRead("초밥");
		
		System.out.println("팥빙수 가격 변경 (5000 -> 7000) : ");
		FoodController.foodUpdate("팥빙수", 7000);
		FoodController.foodRead("팥빙수");
		
		System.out.println();
		
	}
	
	
	public static void removeFood() {
		System.out.println("*** 현재 DB ***");
		FoodController.foodReadAll();
		System.out.println();
		
		System.out.println("*** 4. Delete 결과 ***");
		System.out.println("초밥 삭제");
		FoodController.foodDelete("초밥");
		FoodController.foodReadAll();
		System.out.println();
		
		System.out.println("팥빙수 삭제");
		FoodController.foodDelete("팥빙수");
		FoodController.foodReadAll();
		
		System.out.println();
		
	}
	
	public static void main(String[] args) {
		putFood();
		getFood();
		changePrice();
		removeFood();
	}

}
