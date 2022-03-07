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

	// ���� �ϳ� ��������
	public void getItem(String itemName) {
		try {
			EndView.itemView(service.getItemName(itemName));
		} catch (ItemNotFoundException e) {
			e.printStackTrace();
			EndFailView.failView(e.getMessage());
		}
	}

	// ���� ��ü ��������
	public void getItemList() {
		EndView.itemListView(service.getItemList());
	}

	// ���� ����
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
			EndFailView.failView("�Է��Ͻ� �����͸� Ȯ�����ּ���!");
		}
	}

	// �� ����ڰ� ���� ���� �ϳ� ��������
	public void itemRead(String itemName) {
		try {
			service.itemRead(itemName);
			EndView.itemView(service.getItemName(itemName));

		} catch (ItemNotFoundException e) {
			e.printStackTrace();
			EndFailView.failView(e.getMessage());
		}

	}

	// ����
	public void itemTradeUpdate(String name, String nickname, int newpw, int newprice) {
		if (name != null && nickname != null && newpw != 0) {
			boolean result = service.itemTradeUpdate(name, nickname, newpw, newprice);

			if (result) {
				try {
					EndView.itemView(service.getItemTrade(name));
				} catch (ItemNotFoundException e) {
					e.printStackTrace();
					EndFailView.failView("���� �� �˻� ����");
				}
			} else {
				EndFailView.failView("�������� �ʴ� ���� �õ�");
			}
		} else {
			EndFailView.failView("��ȿ���� ���� ��������");
		}
	}

	// ����
	public void itemDelete(String name, int pw) {
		if (name != null && pw != 0) {
			try {
				service.itemDelete(name, pw);
				EndView.successView("������ ���������� �����Ǿ����ϴ�.");
			} catch (ItemDeleteErrorException e) {
				e.printStackTrace();
				EndFailView.failView(e.getMessage());
			}
		} else {
			EndFailView.failView("���� Ȥ�� ��й�ȣ�� �ùٸ��� �Էµ��� �ʾҽ��ϴ�.");
		}
	}

	// �ŷ�
	public void itemTrade(String wantItem, String name) {
		if (wantItem != null && name != null) {
			try {
				service.itemTrade(wantItem, name);
				EndView.successView("�ŷ��� ���������� �Ϸ�Ǿ����ϴ�. �Ϸ� ��ǰ�� �����˴ϴ�.");
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
			EndFailView.failView("���ϴ� ���ǰ� ã�� ������ ������ ����� �Էµ��� �ʾҽ��ϴ�.");
		}
	}

}
