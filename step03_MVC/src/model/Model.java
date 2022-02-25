package model;

public class Model {
	//controller의 요청으로 한명의 정보를 db로부터 검색해서 CustomerDTO 정보를 제공
	public static CustomerDTO getCustomer() {
		//객체 생성
		//setXxx()메소드로 id = encore, pw = 12, grade = gold
		//반환
		
		CustomerDTO c = new CustomerDTO();
		c.setId("encore");
		c.setPw(12);
		c.setGrade('g');
		
		return c;
	}
	
	//고객들을 모두 반환
	
	public static CustomerDTO[] getCustomers() {
		CustomerDTO[] c = {new CustomerDTO("id1",11,'g', "개발"),
						new CustomerDTO("id2",22,'s', "기획")};
		
		return c;
	}
	
	//..CRUD
}
