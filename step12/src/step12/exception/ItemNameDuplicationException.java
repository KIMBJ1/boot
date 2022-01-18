package step12.exception;

public class ItemNameDuplicationException extends Exception {
	
	public ItemNameDuplicationException() {}

	// 상속받은 message라는 변수에 값 대입하는 원리
	public ItemNameDuplicationException(String msg) {
		super(msg);
	}
		
}