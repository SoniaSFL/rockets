package fase4;

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
		
		printSpeed(rocket1, rocket2);
		
		for (i = 0; i < 3; i++) {
			rocket1.accelerate();
			rocket2.accelerate();
		}
		
		printSpeed(rocket1, rocket2);
		
		for (i = 0; i < 5; i++) {
			rocket1.brake();
			rocket2.accelerate();
		}
		for (i = 0; i < 2; i++) {
			rocket2.accelerate();
		}
		
		printSpeed(rocket1, rocket2);
		
		for (i = 0; i < 15; i++) {
			rocket1.accelerate();
			rocket2.accelerate();
		}
		
		printSpeed(rocket1, rocket2);
		
	}
	
	public static void printSpeed(Rocket rocket1, Rocket rocket2) {
		System.out.println("\nRocket " + rocket1.getCode() + " current speed: " + rocket1.getCurrentSpeed());
		System.out.println("Rocket " + rocket2.getCode() + " current speed: " + rocket2.getCurrentSpeed());
	}
	
}
