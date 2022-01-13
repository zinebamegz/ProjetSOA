package fr.insa.MovSensor.Model;

public class MovSensor {
	
	/*Variable for motion detection 
	 * True = detected 
	 * False = no detection
	*/
	private boolean Motion; 
	
	/*Constructors*/
	public MovSensor() {
		this.Motion = false; // No motion detected by default
	}	
	
	public MovSensor(boolean motion) {
		this.Motion = motion; 
	}

	public boolean getMotion() {
		return Motion;
	}

	public void setMotion(boolean motion) {
		this.Motion = motion;
	}
	
}
