package exception;

public class idInvalidateException extends Exception {
	public idInvalidateException() {}
	
	//특정 메세지로 상황에 적합한 예외 구성을 의미
	public idInvalidateException(String m) { 
		super(m);
	}
}
