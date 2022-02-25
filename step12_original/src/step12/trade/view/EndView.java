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
	public static void itemListView(ArrayList<Item> allItem){
		
		if( allItem != null ) {
			int projectSize = allItem.size();  
			
			for(int index = 0; index < projectSize; index++){	
				if(allItem.get(index) != null){
					System.out.println("[진행 중인 project : " + (index+1) + "] " + allItem.get(index));
				}
			}
		}else {
			System.out.println("현 진행중인 project는 미존재합니다");
		}
	}
	
}
