package fase1;

public class Main {
	
	public static void main(String[] args) {
		
		Rocket rocket1 = null;
		Rocket rocket2 = null;
		int i = 0;
		
		try {
			rocket1 = new Rocket("32WESSDS");
			for (i = 0; i < 3; i++) {
				rocket1.addThruster("Thruster " + (i+1) + " " + rocket1.getCode());
			}
			rocket2 = new Rocket("LDSFJA32");
			for (i = 0; i < 6; i++) {
				rocket2.addThruster("Thruster " + (i+1) + " " + rocket2.getCode());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Rocket 1: " + rocket1.toString());
		System.out.println("Rocket 2: " + rocket2.toString());
		
	}
	
}
