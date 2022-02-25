package step02.probono.exception;

public class ProjectNotFoundException extends Exception{
	public ProjectNotFoundException() {}
	public ProjectNotFoundException(String msg) { //상속받는 message라는 변수에 값 대입
		super (msg);
	}
}
