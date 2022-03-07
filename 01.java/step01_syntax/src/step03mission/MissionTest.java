package step03mission;

public class MissionTest {

	public static void main(String[] args) {
		Mission car1 = new Mission();
		Mission car2 = new Mission();
		
		car1.setcarName("현대");
		car2.setcarName("기아");
		
		
		car1.setcolor("black");
		car2.setcolor("white");
		
		car1.setbacknumber(1234);
		car2.setbacknumber(9876);
		
		System.out.println(car1.carName + " " + car1.color + " " + car1.backnumber);
		System.out.println(car2.getcarName() + " " + car2.getcolor() + " " + car2.getbacknumber());

	}

}
