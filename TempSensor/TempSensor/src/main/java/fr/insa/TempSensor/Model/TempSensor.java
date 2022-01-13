package fr.insa.TempSensor.Model;

public class TempSensor {
	//**************************** VARIABLES ****************************
	private double temp_value;

	//**************************** CONSTRUCTOR ****************************
	public TempSensor() {
		this.temp_value = 25; //Default
	}
	
	public TempSensor(double temp) {
		this.temp_value = temp; 
	}

	//**************************** METHODS ****************************

	public double getTemp_value() {
		return temp_value;
	}

	public void setTemp_value(double temp) {
		this.temp_value = temp;
	}
	
}
