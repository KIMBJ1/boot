package step12.trade.view;

import java.util.ArrayList;

import step12.trade.dto.Item;

public class EndView {
	
	public static void successView(String message) {
		System.out.println(message);
	}

	//�������� Ư�� ������Ʈ ��� 
	public static void itemView(Item item){
		if(item != null) {
			System.out.println(item);		
		}else {
			System.out.println("�ش� ������Ʈ�� �������� �ʽ��ϴ�.");
		}
	}
	
	//TO DO
	//�������� ��� ������Ʈ ���
	public static void itemListView(ArrayList<Item> allItem){
		
		if( allItem != null ) {
			int projectSize = allItem.size();  
			
			for(int index = 0; index < projectSize; index++){	
				if(allItem.get(index) != null){
					System.out.println("[���� ���� project : " + (index+1) + "] " + allItem.get(index));
				}
			}
		}else {
			System.out.println("�� �������� project�� �������մϴ�");
		}
	}
	
}
