package model;

import java.util.HashMap;

import exception.KeyInvalidateException;
import model.dto.Food;

public class FoodModel {
	
	private static HashMap<String, Food> foods = new HashMap<String, Food>();
	
	// 기본 DB
	static {
		foods.put("초밥", new Food("01a", "초밥", "일식", 12000));
		foods.put("파스타", new Food("02a", "파스타", "양식", 15000));
		foods.put("스테이크", new Food("03a", "스테이크", "일식", 50000));
		foods.put("김치찌개", new Food("04a", "김치찌개", "한식", 7000));
	}
	
	// 전체 조회
	public static HashMap<String, Food> foodAll(){
		return foods;
	}
	
	// 음식 이름(키)으로 조회
	public static Food food(String foodname) {
		return foods.get(foodname);
	}
	
	
	
	// 1. Create : 음식 이름을 키로 하는 데이터 추가
	public static void create(Food newFood) throws KeyInvalidateException{
		String foodskey = newFood.getFoodname();
		if(foods.containsKey(foodskey)) {
			throw new KeyInvalidateException("음식이 중복되었습니다.");
		}		
		foods.put(foodskey, newFood);
	}		
	
	
	
	// 2. Read - 음식이름으로 가격 검색	
	public static Food read(String foodname) throws Exception {
		Food f = foods.get(foodname);
		if(f == null) {
			throw new Exception("그런 음식 없어요!");
		}else {
			return f;
		}
	}
	
	
	
	// 3. Update - 음식이름으로 가격 변경
	public static boolean update(String foodname, int newPrice) {
		if(foods.containsKey(foodname)) {
			foods.get(foodname).setPrice(newPrice);
			return true;
		}
		return false;
	}
	
	
	
	// 4. Delete - 음식이름으로 음식 제거
	public static boolean delete(String foodname) {
		if(foods.containsKey(foodname)) {
			foods.remove(foodname);
			return true;
		}
		return false;
	}
	
	
}
