package fr.insa.HeaterActuator.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/HeaterActuator/")
public class HeaterActuatorRessource {
	//**************************** VARIABLES ****************************
	
		private boolean active; // true if heater on, false if heater off
		private double temperatureToReach; //value up to which the heater should heat up
		
		//**************************** CONSTRUCTOR ****************************
		public HeaterActuatorRessource() {
			this.active = false; // not active by default
			this.temperatureToReach = 25; // temperature to reach = 25°C by default
		}
		
		//**************************** METHODS ****************************
		
		//return if the heater is active or not
		
		@GetMapping("getActive/") 
		public boolean getActive() {
			return active;
		}
		
		
		//put on or off the heater according to a boolean parameter
		@GetMapping("setActive/") 
		public void setActive(boolean activate) {
			this.active = activate;
		}

		
		//return the temperature to be reach
		
		@GetMapping("getTemperatureToReach/") 
		public double getTemperatureToReach() { 
			return temperatureToReach;
		}

		
		//set the temperature to be reach
		
		@GetMapping(value="/setTemperatureToReach/{temp}")
		public void setTemperatureToReach(@PathVariable double temp) {
			this.temperatureToReach = temp;
		}
}
