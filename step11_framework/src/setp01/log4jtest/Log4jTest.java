package setp01.log4jtest;

import org.apache.log4j.Logger;

public class Log4jTest {
	//Logger ��ü�� singleton���� ���ߵǾ� �� �Ӥ���
	//log4jTest ����� ��� ���
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
			System.out.println("id ��ȿ"); //�ֹ�
		}
	}
	public static void logout(String id) {
		//..���� �ð� üũ����� ����
		
	}
	public static void main(String[] args) {
		login("playdataaa");
	}

}
