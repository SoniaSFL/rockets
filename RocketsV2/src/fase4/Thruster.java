package fase4;

import java.util.concurrent.CountDownLatch;

public class Thruster extends Thread {
	
	private int maxPower;
	private int currentPower;
	private RocketAction action;
	private Thruster thruster = null;
	private CountDownLatch doneSignal = null;
	
	public Thruster(String name, int maxPower) throws Exception {
		super(name);
		if (maxPower <= 0) throw new Exception("Max power must be greater than 0");
		
		this.maxPower = maxPower;
		this.currentPower = 0;
	}
	
	public Thruster(Thruster thruster) {
		super(thruster.getName());
		this.thruster = thruster;
		this.maxPower = thruster.getMaxPower();
		this.currentPower = thruster.getCurrentPower();
		this.action = thruster.getAction();
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
	
	public void setSignal(CountDownLatch doneSignal) {
		this.doneSignal = doneSignal;
	}
	
	public void addPower() {
		thruster.setCurrentPower(currentPower + 10);
	}
	
	public void reducePower() {
		thruster.setCurrentPower(currentPower - 10);
	}
	
	@Override
	public Thruster clone() {
		return new Thruster(this);
	}
	
	@Override
	public void run() {
		if (action.equals(RocketAction.ACCELERATE)) {
			addPower();
		} else if (action.equals(RocketAction.BRAKE)) {
			reducePower();
		}
		System.out.println(thruster.getName() + " current power: " + thruster.getCurrentPower());
		doneSignal.countDown();
	}
	
}
