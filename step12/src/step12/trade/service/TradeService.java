package step12.trade.service;

import java.util.ArrayList;

import step12.exception.ItemNameDuplicationException;
import step12.exception.ItemNotFoundExcpetion;
import step12.trade.dto.Item;

public class TradeService {
	
	private static TradeService instance = new TradeService();
	
	private ArrayList<Item> itemList = new ArrayList<Item>();
	
	private TradeService() {}

	public static TradeService getInstance() {
		return instance;
	}
	
	// getItemList() = 모든 itemList 
	public ArrayList<Item> getItemList(){
		return itemList;
	}
	
	// getItem(String item) = 입력한 item에 해당하는 Item 객체 출력
	public Item getItem(String itemName) throws ItemNotFoundExcpetion{
		for(Item item : itemList) {
			if(item.getName().equals(itemName)) {
				return item;
			}
		}
		throw new ItemNotFoundExcpetion("입력하신 물건 이름이 DB에 없습니다");
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
	
	// 등록되어있는 물건 수정 (물건이름, 판매자 이름)으로 검색 -> 가격 수정
	public boolean itemPriceUpdate(String itemName, int pw, int newPrice) throws ItemNotFoundExcpetion{
		for(Item item : itemList) {
			
			if( item.getName().equals(itemName) && item.getUser().getPw() == pw) {
			// itemList에 있는 item - 물건 이름, 판매자 이름이 입력받은 itemName, seller와 동일하면 실행되는 문장
				item.setPrice(newPrice);
				return true;
			}
		}
		// itemList에 있는 item - 물건 이름이 존재하지 않는 경우 > 바로 if문 false
		throw new ItemNotFoundExcpetion("입력하신 item정보가 없습니다");
	}
	
	// 등록되어있는 물건 수정 (물건이름, 판매자 이름)으로 검색 -> 물건 이름 수정
	public void itemNameUpdate(String itemName, String seller, String newName) throws ItemNotFoundExcpetion{
		for(Item item : itemList) {
			if(item.getName().equals(itemName) && item.getSeller().equals(seller)) {
			// itemList에 있는 item - 물건 이름, 판매자 이름이 입력받은 itemName, seller와 동일하면 실행되는 문장
				item.setName(newName);
				break;
			}
		}
		// itemList에 있는 item - 물건 이름이 존재하지 않는 경우 > 바로 if문 false
		throw new ItemNotFoundExcpetion("입력하신 item정보가 없습니다");
	}
	
	// itemRead() : 입력받은 itemName이 itemList 내에 있는지 확인 > 있으면 객체 반환, 없으면 예외 처리
	public Item itemRead(String itemName) throws ItemNotFoundExcpetion {
		for(Item item : itemList) {
			if(item.getName().equals(itemName)) {
				item.addViewCnt();
				return item;
			}
		}
		throw new ItemNotFoundExcpetion("item 이름을 정확하게 입력해주세요");
	}
	
	// itemDelete() : 구매자가 원하는 물건 이름 = 판매하는 물건 이름 >> 구매로 간주, itemList에서 삭제
	//
	public boolean itemDelete(String userWantItem, String buyingItemName) throws ItemNotFoundExcpetion{
		for(Item item : itemList) {
			if(item.getName().equals(buyingItemName) && item.getName().equals(userWantItem)) {
				itemList.remove(item);
				return true;
			}
		}
		throw new ItemNotFoundExcpetion("구매하고자 하는 물건 이름을 정확하게 입력하세요.");
	}
	
	
	
	
	
}
