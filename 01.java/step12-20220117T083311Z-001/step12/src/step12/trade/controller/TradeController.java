package step12.trade.controller;

import step12.trade.dto.Item;
import step12.trade.dto.User;
import step12.trade.exception.ItemNameDuplicationExcpetion;
import step12.trade.exception.ItemNotFoundException;
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

	public void newItemInsert(Item newItem) {
		if(newItem != null) {
			
			try {
				service.newItemInsert(newItem);
				EndView.itemView(newItem);
				
			} catch (ItemNameDuplicationExcpetion e) {
				e.printStackTrace();
				EndFailView.failView(e.getMessage());
			}
			
		}else {
			EndFailView.failView("�Է��Ͻ� �����͸� Ȯ�����ּ���!");
		}
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
	
	public void itemTradeUpdate(String name, String nickname, int newpw, int newprice) {
		if(name != null && nickname != null && newpw != 0) {
			boolean result = service.itemTradeUpdate(name, nickname, newpw, newprice);
			
			if(result) {
				try {
					EndView.projectView(service.getItemTrade(name));
				}  catch(ItemNotFoundException e) {
					e.printStackTrace();
					EndFailView.failView("���� �� �˻� ����");
				}
			}else {
				EndFailView.failView("�������� �ʴ� ���� �õ�");
			}
		} else {
			EndFailView.failView("��ȿ���� ���� ��������");
		}
	}
}
