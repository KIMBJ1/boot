package view;

import java.util.HashMap;
import java.util.Iterator;

import model.dto.Food;

public class SuccessView {

	public static void printPrice(int price) {
		System.out.println(price + "원");
	}
	
	public static void printALL(HashMap<String, Food> all) {
		Iterator<String> foodKey = all.keySet().iterator();
		while(foodKey.hasNext()) {
			String key = foodKey.next();
			System.out.println("key : " + key + "Value : " + all.get(key));
		}
	}

}
