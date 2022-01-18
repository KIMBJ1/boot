package step12.trade.service;

import java.util.ArrayList;

import step12.trade.dto.Item;
import step12.trade.exception.ItemDeleteErrorException;
import step12.trade.exception.ItemNameDuplicationException;
import step12.trade.exception.ItemNotFoundException;
import step12.trade.exception.ItemTradeErrorException;

public class TradeService {
	
	private static TradeService instance = new TradeService();
	
	private ArrayList<Item> itemList = new ArrayList<Item>();
	
	private TradeService() {}

	public static TradeService getInstance() {
		return instance;
	}
	
	//모든 Item 검색
	public ArrayList<Item> getItemList() {
		return itemList;
	}
	
	//Item 이름으로 검색
	public Item getItemName(String itemName) throws ItemNotFoundException {
		for (Item e : itemList) {
			if (e.getName().equals(itemName)) {
				return e;
			}
		}
		throw new ItemNotFoundException("해당 상품은 존재하지 않습니다.");
	}
	
	
	
	// 새로운 물건 등록 : 동일한 item명이 있는지 확인 후, 없으면 Insert
	public void newItemInsert(Item newItem) throws ItemNameDuplicationException{
		for(Item item : itemList) {
			if(item.getName().equals(newItem.getName())) {
				throw new ItemNameDuplicationException("동일한 물건명이 존재합니다.");
			}
		}
		itemList.add(newItem);
	}

	
	//물건 삭제
	public void itemDelete(String name, int pw) throws ItemDeleteErrorException{
		Item item = null;
		int cnt = itemList.size();
		boolean flag = false;
		
		for(int i = 0;i<cnt;i++) {
			item = itemList.get(i);
			if(item.getName().equals(name) ) {
				if(item.getUser().getPw()==pw) {
					itemList.remove(i);
					flag = true;
				}
				else {
					throw new ItemDeleteErrorException("이용자의 비밀번호가 일치 하지 않아 삭제가 불가합니다.");
				}
				break;
			}

		}
		if(!flag) {
			throw new ItemDeleteErrorException("거래하려는 물건이 존재하지 않습니다.");
		}
	}
	
	//물건 거래
	public void itemTrade(String wantItem, String name) throws ItemTradeErrorException, ItemDeleteErrorException, ItemNotFoundException {
		if(wantItem.equals(name)) {
			int pw = getItemName(name).getUser().getPw();
			itemDelete(name,pw);
		}
		else {
			throw new ItemTradeErrorException("(거래실패)판매중인 물건 중 고객님께서 찾는 물건은 없습니다.");
		}
	}
}
