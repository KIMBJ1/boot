package step12.trade.exception;

public class ItemNameDuplicationException extends Exception {
	
	public ItemNameDuplicationException() {}

	// ��ӹ��� message��� ������ �� �����ϴ� ����
	public ItemNameDuplicationException(String msg) {
		super(msg);
	}
		
}