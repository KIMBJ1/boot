package controller;

import java.util.HashMap;

import model.FoodModel;
import model.dto.Food;
import view.FailView;
import view.SuccessView;

public class FoodController {
	
	// 전체 조회
	public static void foodReadAll() {
		HashMap<String, Food> all = FoodModel.foodAll();
		SuccessView.printALL(all);
	}
	
	// 1. foodCreate : 음식 이름을 키로 하는 데이터 추가
	public static void foodCreate(String foodno, String foodname, String foodtype, int price) {
		Food newFood = new Food(foodno, foodname, foodtype, price);
		try {
			FoodModel.create(newFood);
		}catch(Exception e) {
			e.printStackTrace();
			FailView.messageView(e.getMessage());
		}
	}
	
	
	
	// 2. foodRead - 음식이름으로 가격 검색
	public static void foodRead(String foodname) {
		try {
			Food food = FoodModel.read(foodname);
			int price = food.getPrice();
			SuccessView.printPrice(price);
		}catch (Exception e){
			e.printStackTrace();
			FailView.messageView(e.getMessage());
		}
	}
	
	
	
	// 3. Update - 음식이름으로 가격 변경
	public static void foodUpdate(String foodname, int newPrice) {
		try {
			FoodModel.update(foodname, newPrice);
		}catch(Exception e) {
			e.printStackTrace();
			FailView.messageView(e.getMessage());
		}
	}
	
		
	
	// 4. Delete - 음식이름으로 음식 제거
	public static void foodDelete(String foodname) {
		try {
			FoodModel.delete(foodname);
		}catch(Exception e) {
			e.printStackTrace();
			FailView.messageView(e.getMessage());
		}
	}
	

}