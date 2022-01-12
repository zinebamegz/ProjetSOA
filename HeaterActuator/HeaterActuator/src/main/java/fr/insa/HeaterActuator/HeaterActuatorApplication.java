package fr.insa.HeaterActuator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@RequestMapping("/HeaterActuator/")
public class HeaterActuatorApplication {
	//**************************** Variables ****************************
	
	private boolean active; // true if heater on, false if heater off
	private double temperatureToReach; //value up to which the heater should heat up
	
	//**************************** Constructor ****************************
	public HeaterActuatorApplication() {
		this.active = false; // not active by default
		this.temperatureToReach = 25; // temperature to reach = 25°C by default
	}
	
	//**************************** Methodes ****************************
	
	//return if the heater is active or not
	
	@GetMapping("getActive/") 
	public boolean getActive() {
		return active;
	}
	
	
	//put on or off the heater according to a boolean parameter
	
	@GetMapping(value="/setActive/{bool}") 
	public void setActive(@PathVariable boolean bool) {
		this.active = bool;
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
	
	//**************************** Main ****************************
	public static void main(String[] args) {
		SpringApplication.run(HeaterActuatorApplication.class, args);
	}

}
