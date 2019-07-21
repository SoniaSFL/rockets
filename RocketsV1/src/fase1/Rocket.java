package fase1;

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
	
	public void addThruster(String name) {
		thrusters.add(new Thruster(name));
	}
	
	public int getThrustersNumber() {
		return thrusters.size();
	}
	
	@Override
	public String toString() {
		return "Code = " + code + ", Thrusters number = " + getThrustersNumber();
	}
	
}
