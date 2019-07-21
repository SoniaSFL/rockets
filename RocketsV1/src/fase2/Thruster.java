package fase2;

public class Thruster {
	
	private String name;
	private int maxPower;
	
	public Thruster(String name, int maxPower) throws Exception {
		if (maxPower <= 0) throw new Exception("Max power must be greater than 0");
		
		this.name = name;
		this.maxPower = maxPower;
	}
	
	public String getName() {
		return name;
	}
	
	public int getMaxPower() {
		return maxPower;
	}
	
}
