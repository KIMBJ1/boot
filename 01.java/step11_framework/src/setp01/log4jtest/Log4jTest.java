package setp01.log4jtest;

import org.apache.log4j.Logger;

public class Log4jTest {
	//Logger 객체가 singleton으로 개발되어 ㅇ ㅣㅆ음
	//log4jTest 실행시 기록 등록
	static Logger logger = Logger.getLogger("setp01.log4jtest.Log4jTest"); //org.apache.log4j.Logger -> Logger

	public static void login(String id) {
		if(id.equals("playdata")) {
			logger.trace("trace");
			logger.debug("debug");
			logger.info("info");
			logger.warn("warn");
			logger.error("error");
		}else {
			logger.warn("warn : " + id);
			System.out.println("id 무효"); //휘발
		}
	}
	public static void logout(String id) {
		//..언제 시간 체크로직등도 구현
		
	}
	public static void main(String[] args) {
		login("playdataaa");
	}

}
