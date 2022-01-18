package step12.trade.controller;

import step12.trade.dto.Item;
import step12.trade.exception.ItemDeleteErrorException;
import step12.trade.exception.ItemNameDuplicationException;
import step12.trade.exception.ItemNotFoundException;
import step12.trade.exception.ItemTradeErrorException;
import step12.trade.service.TradeService;
import step12.trade.view.EndFailView;
import step12.trade.view.EndView;

public class TradeController {
	private static TradeController instance = new TradeController();

	private TradeService service = TradeService.getInstance();

	private TradeController() {
	}

	public static TradeController getInstance() {
		return instance;
	}

	public void getItem(String itemName) {
		try {
			EndView.itemView(service.getItemName(itemName));
		} catch (ItemNotFoundException e) {
			e.printStackTrace();
			EndFailView.failView(e.getMessage());
		}
	}

	public void getItemList() {
		EndView.itemListView(service.getItemList());
	}

	/*
	 * newItemInsert() : newItem을 itemList에 넣을지 말지 결정 1. newItem이 null이 아닌 경우 if문 실행
	 * 2. service.newItemInsert() : void타입 동일한 물건 명이 존재하지 않아 insert된 경우 >
	 * itemList.add(newItem); 동일한 물건 명이 존재한 경우 > ItemNameDuplicationExcpetion 실행 >
	 * catch문
	 */
	public void newItemInsert(Item newItem) {
		if (newItem != null) {

			try {
				service.newItemInsert(newItem);
				EndView.itemView(newItem);

			} catch (ItemNameDuplicationException e) {
				e.printStackTrace();
				EndFailView.failView(e.getMessage());
			}

		} else {
			EndFailView.failView("입력하신 데이터를 확인해주세요!");
		}
	}

	// 조회수
	public void itemRead(String itemName) {
		try {
				service.itemRead(itemName);
				EndView.itemView(service.getItemName(itemName));

			} catch (ItemNotFoundException e) {
				e.printStackTrace();
				EndFailView.failView(e.getMessage());
			}

		}
	
	
	
	// 삭제
	public void itemDelete(String name, int pw) {
		if (name != null && pw != 0) {
			try {
				service.itemDelete(name, pw);
				EndView.successView("물건이 성공적으로 삭제되었습니다.");
			} catch (ItemDeleteErrorException e) {
				e.printStackTrace();
				EndFailView.failView(e.getMessage());
			}
		} else {
			EndFailView.failView("물건 혹은 비밀번호가 올바르게 입력되지 않았습니다.");
		}
	}

	// 거래
	public void itemTrade(String wantItem, String name) {
		if (wantItem != null && name != null) {
			try {
				service.itemTrade(wantItem, name);
				EndView.successView("거래가 성공적으로 완료되었습니다. 완료 물품은 삭제됩니다.");
			} catch (ItemTradeErrorException e) {
				e.printStackTrace();
				EndFailView.failView(e.getMessage());
			} catch (ItemDeleteErrorException e) {
				e.printStackTrace();
				EndFailView.failView(e.getMessage());
			} catch (ItemNotFoundException e) {
				e.printStackTrace();
				EndFailView.failView(e.getMessage());
			}
		} else {
			EndFailView.failView("원하는 물건과 찾는 물건의 정보가 제대로 입력되지 않았습니다.");
		}
	}
}
