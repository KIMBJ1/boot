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

	// ��� Item �˻�
	public ArrayList<Item> getItemList() {
		return itemList;
	}

	// Item �̸����� �˻�
	public Item getItemName(String itemName) throws ItemNotFoundException {
		for (Item e : itemList) {
			if (e.getName().equals(itemName)) {
				return e;
			}
		}
		throw new ItemNotFoundException("�ش� ��ǰ�� �������� �ʽ��ϴ�.");
	}

	// ���ο� ���� ��� : ������ item���� �ִ��� Ȯ�� ��, ������ Insert
	public void newItemInsert(Item newItem) throws ItemNameDuplicationException {
		for (Item item : itemList) {
			if (item.getName().equals(newItem.getName())) {
				throw new ItemNameDuplicationException("������ ���Ǹ��� �����մϴ�.");
			}
		}
		itemList.add(newItem);
	}

	// �� ����ڰ� ���� ���� ��������
	public Item itemRead(String itemRead) throws ItemNotFoundException {
		for (Item i : itemList) {
			if (i.getName().equals(itemRead)) {
				i.addViewCnt();
				return i;
			}
		}
		throw new ItemNotFoundException("����ε� item���� �Է��ϼ���.");
	}

	// ����

	public Item getItemTrade(String name) throws ItemNotFoundException {
		for (Item i : itemList) {
			if (i.getName().equals(name)) {
				return i;
			}
		}
		throw new ItemNotFoundException("ã������ item �������� ����");
	}

	public boolean itemTradeUpdate(String name, String nickname, int newpw, int newprice) {
		for (Item item : itemList) {
			if ((item.getName().equals(name) && item.getUser().getPw() == (newpw))
					&& item.getUser().getNickname().equals(nickname)) {
				item.setPrice(newprice);
				return true;
			}
		}
		return false;
	}

	// ���� ����
	public void itemDelete(String name, int pw) throws ItemDeleteErrorException {
		Item item = null;
		int cnt = itemList.size();
		boolean flag = false;

		for (int i = 0; i < cnt; i++) {
			item = itemList.get(i);
			if (item.getName().equals(name)) {
				if (item.getUser().getPw() == pw) {
					itemList.remove(i);
					flag = true;
				} else {
					throw new ItemDeleteErrorException("�̿����� ��й�ȣ�� ��ġ ���� �ʾ� ������ �Ұ��մϴ�.");
				}
				break;
			}

		}
		if (!flag) {
			throw new ItemDeleteErrorException("�ŷ��Ϸ��� ������ �������� �ʽ��ϴ�.");
		}
	}

	// ���� �ŷ�
	public void itemTrade(String wantItem, String name)
			throws ItemTradeErrorException, ItemDeleteErrorException, ItemNotFoundException {
		if (wantItem.equals(name)) {
			int pw = getItemName(name).getUser().getPw();
			itemDelete(name, pw);
		} else {
			throw new ItemTradeErrorException("(�ŷ�����)�Ǹ����� ���� �� ���Բ��� ã�� ������ �����ϴ�.");
		}
	}

}
