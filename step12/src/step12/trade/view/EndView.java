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
	public static void itemListView(ArrayList<Item> itemList){
		
		if( itemList != null ) {
			int projectSize = itemList.size();  
			
			for(int index = 0; index < projectSize; index++){	
				if(itemList.get(index) != null){
					System.out.println("[ �����ϴ� ���� : " + (index+1) + "] " + itemList.get(index));
				}
			}
		}else {
			System.out.println("�ش� ������ �������� �ʽ��ϴ�");
		}
	}

	public static void itemView(String itemName) {
		
		if (itemName != null) {
			System.out.println(itemName);
		} else {
			System.out.println("�ش� ��ǰ�� �������� �ʽ��ϴ�.");
		}
	}
}
