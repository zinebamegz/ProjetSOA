package fr.insa.TempSensor.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/TempSensor/")
@RestController

public class TempSensorRessource {
	//**************************** VARIABLES ****************************
	private double temp_value;

	//**************************** CONSTRUCTOR ****************************
	public TempSensorRessource() {
		this.temp_value = 25; 
	}
	
	//**************************** METHODS ****************************

	@GetMapping("getTemp/")
	public double getTemp() {
		return temp_value;
	}
	
	@GetMapping(value="/setTemp/{temperature}")
	public void setTemp(@PathVariable double temperature) {
		this.temp_value = temperature;
	}
}
