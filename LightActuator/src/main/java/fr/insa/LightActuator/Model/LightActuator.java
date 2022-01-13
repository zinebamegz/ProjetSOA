package fr.insa.LightActuator.Model;

public class LightActuator {
	
	//The state of the lights ( true = ON; false=OFF)
	private boolean State; 
	
	public LightActuator() {
		this.State = false; // Turned off by default
	}	
	
	public LightActuator(boolean etat) {
		this.State = etat; 
	}

	public boolean getState() {
		return State;
	}

	public void setState(boolean state) {
		State = state;
	}	
	
	
}
