package step06.mission;

public class Mission01Cannon {
	//대포 갯수 5개
	int r = 5;
	
	void attCastle () {
		
		//공격하면 성 체력 -20
		Mission01Castle.hp = Mission01Castle.hp - 20;
		r--;
	}
	
	
}
