package step12.exception;

public class ItemNameDuplicationException extends Exception {
	
	public ItemNameDuplicationException() {}

	// ��ӹ��� message��� ������ �� �����ϴ� ����
	public ItemNameDuplicationException(String msg) {
		super(msg);
	}
		
}