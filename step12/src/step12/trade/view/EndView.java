package step12.trade.view;

import java.util.ArrayList;

import step12.trade.dto.Item;

public class EndView {
	
	public static void successView(String message) {
		System.out.println(message);
	}

	//진행중인 특정 프로젝트 출력 
	public static void itemView(Item item){
		if(item != null) {
			System.out.println(item);		
		}else {
			System.out.println("해당 프로젝트는 존재하지 않습니다.");
		}
	}
	
	//TO DO
	//진행중인 모든 프로젝트 출력
	public static void itemListView(ArrayList<Item> itemList){
		
		if( itemList != null ) {
			int projectSize = itemList.size();  
			
			for(int index = 0; index < projectSize; index++){	
				if(itemList.get(index) != null){
					System.out.println("[ 존재하는 물건 : " + (index+1) + "] " + itemList.get(index));
				}
			}
		}else {
			System.out.println("해당 물건은 존재하지 않습니다");
		}
	}

	public static void itemView(String itemName) {
		
		if (itemName != null) {
			System.out.println(itemName);
		} else {
			System.out.println("해당 제품은 존재하지 않습니다.");
		}
	}
}
