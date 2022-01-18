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
	
	/* getItemList() :��� itemList ������ �������� �޼ҵ�
	service.getItem() = itemList ��ü
	EndView.itemListView() = itemList ���� �ִ� item�� �� �پ� ���
	*/
	public void getItemList() {
		EndView.itemListView(service.getItemList());
	}
	
	
	/* getItem() : �Է��� ���� �̸� �˻�(service.getItem())  
	1) ���������� �Է��Ͽ� Item��ü�� �Ѿ����, EndView.itemView()�޼ҵ带 ���� ���
	2) itemList�� ���� ���� �̸��� �˻��� ��� ItemNotFoundExcpetion ���� �߻�
		> EndFailView.failView()�޼ҵ带 ���� ���� �Ǽ��ߴ��� �˷���
	*/
	public void getItem(String itemName) {
		try {
			// getItem()���� ã������ Item ��ü�� ������
			EndView.itemView(service.getItem(itemName));
			
		} catch (ItemNotFoundExcpetion e) {
			e.printStackTrace();
			EndFailView.failView(e.getMessage());
		}
	}
	
	/* newItemInsert() : newItem�� itemList�� ������ ���� ����
	1. newItem�� null�� �ƴ� ��� if�� ����
	2. service.newItemInsert() : voidŸ��
		������ ���� ���� �������� �ʾ� insert�� ��� > itemList.add(newItem);
		������ ���� ���� ������ ��� > ItemNameDuplicationExcpetion ���� > catch��
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
			EndFailView.failView("�Է��Ͻ� �����͸� Ȯ�����ּ���!");
		}
	}
	
	public boolean itemPriceUpdate(String itemName, int pw, int newPrice) {
		if(itemName != null && pw != 0) {
			try {
				/* service.itemPriceUpdate()�� �Էµ� ������ itemList ���� �ִ� ������
				 1) ������ ��� : item.setPrice(newPrice)�� ���� ������ ������ ���� > true ��ȯ
				 2) �������� ���� ��� : ItemNotFoundExcpetion ���� �߻�
				*/
				service.itemPriceUpdate(itemName, pw, newPrice);
				EndView.itemView(service.getItem(itemName));
				
			} catch (ItemNotFoundExcpetion e) {
				e.printStackTrace();
				EndFailView.failView(e.getMessage());
			}
			
		}else {
			System.out.println("���� �̸��� �Ǹ��� ������ ����� �Է��ϼ���!!");
		}
		return false;
	}

	public void itemNameUpdate(String itemName, String seller, String newName) {
		if(itemName != null && seller != null) {
			try {
				/* 
				 service.itemNameUpdate(); �� ���� �Է¹��� itemName�� seller�� item��
				 1) ������ ��� : item.setName(newName); �� ���� �̸� ����
				 2) �������� ���� ��� : ItemNotFoundExcpetion ���� �߻�
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
			service.itemRead(); �� ���� �Է¹��� itemName�� itemList���� �ִ� item���� 
			1) ������ ��� : �ش��ϴ� item��ü return
			2) �������� ���� ��� : ItemNotFoundExcpetion ���� �߻�
			 */
			service.itemRead(itemName);
			EndView.itemView(service.getItem(itemName));
			
		} catch (ItemNotFoundExcpetion e) {
			e.printStackTrace();
			EndFailView.failView(e.getMessage());
		}
	}
	
	// delete�� ���� ������.
	public void itemDelete(String userWantItem, String buyingItemName) {
		try {
			/*
			service.itemDelete(); �� ���� userWantItem�� buyingItemName�� itemList���� �ִ� name�� 
			1) ������ ��� : �ش��ϴ� item ��ü ����
			2) �������� ���� ��� : ItemNotFoundExcpetion ���� �߻�
			 */
			service.itemDelete(userWantItem, buyingItemName);
			EndView.itemView(service.getItem(userWantItem));
			
		} catch (ItemNotFoundExcpetion e) {
			e.printStackTrace();
			EndFailView.failView(e.getMessage());
		}
		
		
		
	}
}
