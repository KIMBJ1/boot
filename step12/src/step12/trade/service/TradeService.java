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
	
	// getItemList() = ��� itemList 
	public ArrayList<Item> getItemList(){
		return itemList;
	}
	
	// getItem(String item) = �Է��� item�� �ش��ϴ� Item ��ü ���
	public Item getItem(String itemName) throws ItemNotFoundExcpetion{
		for(Item item : itemList) {
			if(item.getName().equals(itemName)) {
				return item;
			}
		}
		throw new ItemNotFoundExcpetion("�Է��Ͻ� ���� �̸��� DB�� �����ϴ�");
	}
	
	
	
	// ���ο� ���� ��� : ������ item���� �ִ��� Ȯ�� ��, ������ Insert
	public void newItemInsert(Item newItem) throws ItemNameDuplicationException{
		for(Item item : itemList) {
			if(item.getName().equals(newItem.getName())) {
				throw new ItemNameDuplicationException("������ ���Ǹ��� �����մϴ�.");
			}
		}
		itemList.add(newItem);
	}
	
	// ��ϵǾ��ִ� ���� ���� (�����̸�, �Ǹ��� �̸�)���� �˻� -> ���� ����
	public boolean itemPriceUpdate(String itemName, int pw, int newPrice) throws ItemNotFoundExcpetion{
		for(Item item : itemList) {
			
			if( item.getName().equals(itemName) && item.getUser().getPw() == pw) {
			// itemList�� �ִ� item - ���� �̸�, �Ǹ��� �̸��� �Է¹��� itemName, seller�� �����ϸ� ����Ǵ� ����
				item.setPrice(newPrice);
				return true;
			}
		}
		// itemList�� �ִ� item - ���� �̸��� �������� �ʴ� ��� > �ٷ� if�� false
		throw new ItemNotFoundExcpetion("�Է��Ͻ� item������ �����ϴ�");
	}
	
	// ��ϵǾ��ִ� ���� ���� (�����̸�, �Ǹ��� �̸�)���� �˻� -> ���� �̸� ����
	public void itemNameUpdate(String itemName, String seller, String newName) throws ItemNotFoundExcpetion{
		for(Item item : itemList) {
			if(item.getName().equals(itemName) && item.getSeller().equals(seller)) {
			// itemList�� �ִ� item - ���� �̸�, �Ǹ��� �̸��� �Է¹��� itemName, seller�� �����ϸ� ����Ǵ� ����
				item.setName(newName);
				break;
			}
		}
		// itemList�� �ִ� item - ���� �̸��� �������� �ʴ� ��� > �ٷ� if�� false
		throw new ItemNotFoundExcpetion("�Է��Ͻ� item������ �����ϴ�");
	}
	
	// itemRead() : �Է¹��� itemName�� itemList ���� �ִ��� Ȯ�� > ������ ��ü ��ȯ, ������ ���� ó��
	public Item itemRead(String itemName) throws ItemNotFoundExcpetion {
		for(Item item : itemList) {
			if(item.getName().equals(itemName)) {
				item.addViewCnt();
				return item;
			}
		}
		throw new ItemNotFoundExcpetion("item �̸��� ��Ȯ�ϰ� �Է����ּ���");
	}
	
	// itemDelete() : �����ڰ� ���ϴ� ���� �̸� = �Ǹ��ϴ� ���� �̸� >> ���ŷ� ����, itemList���� ����
	//
	public boolean itemDelete(String userWantItem, String buyingItemName) throws ItemNotFoundExcpetion{
		for(Item item : itemList) {
			if(item.getName().equals(buyingItemName) && item.getName().equals(userWantItem)) {
				itemList.remove(item);
				return true;
			}
		}
		throw new ItemNotFoundExcpetion("�����ϰ��� �ϴ� ���� �̸��� ��Ȯ�ϰ� �Է��ϼ���.");
	}
	
	
	
	
	
}
