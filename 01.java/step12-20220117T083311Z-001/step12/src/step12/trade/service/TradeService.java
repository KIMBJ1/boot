package step12.trade.service;

import java.util.ArrayList;

import step12.trade.dto.Item;
import step12.trade.dto.User;
import step12.trade.exception.ItemNameDuplicationExcpetion;
import step12.trade.exception.ItemNotFoundException;

public class TradeService {
	
	private static TradeService instance = new TradeService();
	
	private ArrayList<Item> itemList = new ArrayList<Item>();
	
	private TradeService() {}

	public static TradeService getInstance() {
		return instance;
	}

	public void newItemInsert(Item newItem) throws ItemNameDuplicationExcpetion{
		for(Item item : itemList) {
			if(item.getName().equals(newItem.getName())) {
				throw new ItemNameDuplicationExcpetion("동일한 물건명이 존재합니다.");
			}
		}
		itemList.add(newItem);
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
	
	public Item getItemTrade(String name) throws ItemNotFoundException {
	for(Item i : itemList) {
		if(i.getName().equals(name)) {
			return i;
		}
	}
	throw new ItemNotFoundException("zxcv");
	}

	public boolean itemTradeUpdate(String name, String nickname, int newpw, int newprice) {
		for(Item item : itemList) {
			if((item.getName().equals(name) && item.getSeller().getPw() == (newpw)) && item.getSeller().getNickname().equals(nickname)) {
				item.setPrice(newprice);
				return true;
			}
		}
		return false;
	}
}
