package fr.insa.LightActuator.Model;

public class LightActuator {

	/*Variable for state of lights
	 * True = ON 
	 * False = OFF
	*/
	private boolean State; 
	
	/*Constructors*/
	public LightActuator() {
		this.State = false; // Turned off by default
	}	
	
	public LightActuator(boolean state) {
		this.State = state; 
	}

	public boolean getState() {
		return State;
	}

	public void setState(boolean state) {
		this.State = state;
	}	
	
	
}
