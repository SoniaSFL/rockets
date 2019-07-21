package fase2;

import java.util.ArrayList;
import java.util.List;

public class Rocket {
	
	private String code;
	private List<Thruster> thrusters;
	
	public Rocket(String code) throws Exception {
		if (code.length() != 8) throw new Exception("Rocket's code must have 8 characters");
		
		this.code = code;
		this.thrusters = new ArrayList<>();
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
	
	@Override
	public String toString() {
		int i = 0;
		StringBuilder sb = new StringBuilder()
			.append("Code = ").append(code)
			.append(", Thrusters number = ").append(getThrustersNumber())
			.append(", Thrusters max power = ");
		for (i = 0; i < thrusters.size(); i++) {
			sb.append(thrusters.get(i).getMaxPower() + " ");
		}
		return sb.toString();
	}
	
}
