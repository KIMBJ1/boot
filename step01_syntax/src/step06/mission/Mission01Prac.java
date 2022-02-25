package step06.mission;

public class Mission01Prac {

	public static void main(String[] args) {
		
		// 성 부수기
		Mission01Cannon c = new Mission01Cannon(); 	// 대포 객체 하나 생성
		Mission01Aid a = new Mission01Aid();			// 힐팩 객체 하나 생성
		
		//성 부수기 4번 성 힐 1번
		c.attCastle();
		c.attCastle();
		c.attCastle();
		a.healCastle();
		
		System.out.println(Mission01Castle.hp);
		
	}

}
