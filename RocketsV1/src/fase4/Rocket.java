package fase4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Rocket {
	
	private String code;
	private List<Thruster> thrusters;
	private float currentSpeed;
	
	public Rocket(String code) throws Exception {
		if (code.length() != 8) throw new Exception("Rocket's code must have 8 characters");
		
		this.code = code;
		this.thrusters = new ArrayList<>();
		this.currentSpeed = 0;
	}
	
	public String getCode() {
		return code;
	}
	
	public void addThruster(String name, int maxPower) throws Exception {
		thrusters.add(new Thruster(name, maxPower));
	}
	
	public int getThrustersNumber() {
		return thrusters.size();
	}
	
	public float getCurrentSpeed() {
		return currentSpeed;
	}
	
	public void setCurrentSpeed() {
		this.currentSpeed = calculateSpeed();
	}
	
	public float calculateSpeed() {
		int thrustersPower = 0;
		float speed = currentSpeed;
		for (Thruster thruster : thrusters) {
			thrustersPower += thruster.getCurrentPower();
		}
		int sign = (thrustersPower >= 0)? 1:-1;
		speed += sign * 100 * ((float) Math.sqrt(Math.abs(thrustersPower)));
		return speed;
	}
	
	public void printAction(String action) {
		System.out.println("\nRocket " + code + " " + action);
		System.out.println("...........................");
	}
	
	public synchronized void accelerate() {
		printAction("accelerates");
		runThrusters(RocketAction.ACCELERATE);
	}
	
	public synchronized void brake() {
		printAction("brakes");
		runThrusters(RocketAction.BRAKE);
	}
	
	public void runThrusters(RocketAction action) {
		ExecutorService executor = Executors.newFixedThreadPool(getThrustersNumber());
		for (Thruster thruster : thrusters) {
			thruster.setAction(action);
			executor.execute(thruster);
		}
		executor.shutdown();
		try {
		    if (!executor.awaitTermination(1000, TimeUnit.MILLISECONDS)) {
		        executor.shutdownNow();
		    } 
		} catch (InterruptedException e) {
		    executor.shutdownNow();
		}
		setCurrentSpeed();
		try {
			wait(600);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		int i = 0;
		StringBuilder sb = new StringBuilder()
			.append("Code = ").append(code)
			.append(", Thrusters number = ").append(getThrustersNumber())
			.append(", Thrusters max power = ");
		for (i = 0; i < getThrustersNumber(); i++) {
			sb.append(thrusters.get(i).getMaxPower() + " ");
		}
		return sb.toString();
	}
	
}
