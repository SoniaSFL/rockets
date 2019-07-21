package fase3;

public class Main {
	
	public static void main(String[] args) {
		
		Rocket rocket1 = null;
		Rocket rocket2 = null;
		int[] rocket1Thrusters = {10, 30, 80};
		int[] rocket2Thrusters = {30, 40, 50, 50, 30, 10};
		int i = 0;
		
		try {
			rocket1 = new Rocket("32WESSDS");
			for (i = 0; i < rocket1Thrusters.length; i++) {
				rocket1.addThruster("Thruster " + (i+1) + " " + rocket1.getCode(), rocket1Thrusters[i]);
			}
			rocket2 = new Rocket("LDSFJA32");
			for (i = 0; i < rocket2Thrusters.length; i++) {
				rocket2.addThruster("Thruster " + (i+1) + " " + rocket2.getCode(), rocket2Thrusters[i]);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Rocket 1: " + rocket1.toString());
		System.out.println("Rocket 2: " + rocket2.toString());
		
	}
	
}
