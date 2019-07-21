package fase4;

public class Thruster implements Runnable {
	
	private String name;
	private int maxPower;
	private int currentPower;
	private RocketAction action;
	
	public Thruster(String name, int maxPower) throws Exception {
		if (maxPower <= 0) throw new Exception("Max power must be greater than 0");
		
		this.name = name;
		this.maxPower = maxPower;
		this.currentPower = 0;
	}
	
	public String getName() {
		return name;
	}
	
	public int getMaxPower() {
		return maxPower;
	}
	
	public int getCurrentPower() {
		return currentPower;
	}
	
	public void setCurrentPower(int currentPower) {
		if (Math.abs(currentPower) <= maxPower) {
			this.currentPower = currentPower;
		}
	}
	
	public RocketAction getAction() {
		return action;
	}
	
	public void setAction(RocketAction action) {
		this.action = action;
	}
	
	public void addPower() {
		setCurrentPower(currentPower + 10);
	}
	
	public void reducePower() {
		setCurrentPower(currentPower - 10);
	}
	
	@Override
	public void run() {
		if (action.equals(RocketAction.ACCELERATE)) {
			addPower();
		} else if (action.equals(RocketAction.BRAKE)) {
			reducePower();
		}
		System.out.println(name + " current power: " + currentPower);
	}
	
}
