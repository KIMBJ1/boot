package step12.trade.controller;

import step12.exception.ItemNameDuplicationException;
import step12.exception.ItemNotFoundExcpetion;
import step12.trade.dto.Item;
import step12.trade.service.TradeService;
import step12.trade.view.EndFailView;
import step12.trade.view.EndView;

public class TradeController {
	private static TradeController instance = new TradeController();
	
	private TradeService service = TradeService.getInstance();
	
	private TradeController() {}
	
	public static TradeController getInstance() {
		return instance;
	}
	
	/* getItemList() :모든 itemList 정보를 가져오는 메소드
	service.getItem() = itemList 객체
	EndView.itemListView() = itemList 내에 있는 item을 한 줄씩 출력
	*/
	public void getItemList() {
		EndView.itemListView(service.getItemList());
	}
	
	
	/* getItem() : 입력한 물건 이름 검색(service.getItem())  
	1) 정상적으로 입력하여 Item객체가 넘어오면, EndView.itemView()메소드를 통해 출력
	2) itemList에 없는 물건 이름을 검색한 경우 ItemNotFoundExcpetion 에러 발생
		> EndFailView.failView()메소드를 통해 무슨 실수했는지 알려줌
	*/
	public void getItem(String itemName) {
		try {
			// getItem()에서 찾았으면 Item 객체를 보내줌
			EndView.itemView(service.getItem(itemName));
			
		} catch (ItemNotFoundExcpetion e) {
			e.printStackTrace();
			EndFailView.failView(e.getMessage());
		}
	}
	
	/* newItemInsert() : newItem을 itemList에 넣을지 말지 결정
	1. newItem이 null이 아닌 경우 if문 실행
	2. service.newItemInsert() : void타입
		동일한 물건 명이 존재하지 않아 insert된 경우 > itemList.add(newItem);
		동일한 물건 명이 존재한 경우 > ItemNameDuplicationExcpetion 실행 > catch문
	 */
	public void newItemInsert(Item newItem) {
		if(newItem != null) {
			
			try {
				service.newItemInsert(newItem);
				EndView.itemView(newItem);
				
			} catch (ItemNameDuplicationException e) {
				e.printStackTrace();
				EndFailView.failView(e.getMessage());
			}
			
		}else {
			EndFailView.failView("입력하신 데이터를 확인해주세요!");
		}
	}
	
	public boolean itemPriceUpdate(String itemName, int pw, int newPrice) {
		if(itemName != null && pw != 0) {
			try {
				/* service.itemPriceUpdate()에 입력된 정보와 itemList 내에 있던 정보와
				 1) 동일한 경우 : item.setPrice(newPrice)를 통해 물건의 가격이 수정 > true 반환
				 2) 동일하지 않은 경우 : ItemNotFoundExcpetion 예외 발생
				*/
				service.itemPriceUpdate(itemName, pw, newPrice);
				EndView.itemView(service.getItem(itemName));
				
			} catch (ItemNotFoundExcpetion e) {
				e.printStackTrace();
				EndFailView.failView(e.getMessage());
			}
			
		}else {
			System.out.println("물건 이름과 판매자 정보를 제대로 입력하세요!!");
		}
		return false;
	}

	public void itemNameUpdate(String itemName, String seller, String newName) {
		if(itemName != null && seller != null) {
			try {
				/* 
				 service.itemNameUpdate(); 를 통해 입력받은 itemName과 seller가 item이
				 1) 동일한 경우 : item.setName(newName); 을 통해 이름 변경
				 2) 동일하지 않은 경우 : ItemNotFoundExcpetion 예외 발생
				 */
				service.itemNameUpdate(itemName, seller, newName);
				EndView.itemView(service.getItem(newName));

			} catch (ItemNotFoundExcpetion e) {
//				e.printStackTrace();
				EndFailView.failView(e.getMessage());
			}
		}
	}
	
	public void itemRead(String itemName) {
		try {
			/*
			service.itemRead(); 를 통해 입력받은 itemName과 itemList내에 있는 item명이 
			1) 동일한 경우 : 해당하는 item객체 return
			2) 동일하지 않은 경우 : ItemNotFoundExcpetion 예외 발생
			 */
			service.itemRead(itemName);
			EndView.itemView(service.getItem(itemName));
			
		} catch (ItemNotFoundExcpetion e) {
			e.printStackTrace();
			EndFailView.failView(e.getMessage());
		}
	}
	
	// delete가 뭔가 허접해.
	public void itemDelete(String userWantItem, String buyingItemName) {
		try {
			/*
			service.itemDelete(); 를 통해 userWantItem과 buyingItemName이 itemList내에 있는 name과 
			1) 동일한 경우 : 해당하는 item 객체 삭제
			2) 동일하지 않은 경우 : ItemNotFoundExcpetion 예외 발생
			 */
			service.itemDelete(userWantItem, buyingItemName);
			EndView.itemView(service.getItem(userWantItem));
			
		} catch (ItemNotFoundExcpetion e) {
			e.printStackTrace();
			EndFailView.failView(e.getMessage());
		}
		
		
		
	}
}
