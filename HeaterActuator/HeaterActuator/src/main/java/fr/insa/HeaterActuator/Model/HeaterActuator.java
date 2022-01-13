package fr.insa.HeaterActuator.Model;

public class HeaterActuator {
	//**************************** VARIABLES ****************************
	
		private boolean active; // true if heater on, false if heater off
		private double temperatureToReach; //value up to which the heater should heat up
		
		//**************************** CONSTRUCTORS ****************************
		public HeaterActuator() {
			this.active = false; // not active by default
			this.temperatureToReach = 25; // temperature to reach = 25°C by default
		}
		
		public HeaterActuator(boolean activated, double temp) {
			this.active = activated; 
			this.temperatureToReach = temp; 
		}
		
		public HeaterActuator(boolean activated) {
			this.active = activated; 
			this.temperatureToReach = 25.0; //default
		}
		
		public HeaterActuator(double temp) {
			this.active = false; //default
			this.temperatureToReach = temp; 
		}

		//**************************** METHODS ****************************
		
		public boolean getActive() {
			return active;
		}

		public void setActive(boolean active) {
			this.active = active;
		}

		public double getTemperatureToReach() {
			return temperatureToReach;
		}

		public void setTemperatureToReach(double temperatureToReach) {
			this.temperatureToReach = temperatureToReach;
		}
		
}
