package fr.insa.TempSensor.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import fr.insa.TempSensor.Model.TempSensor;

@RequestMapping("/TempSensor/")
@RestController

public class TempSensorRessource {
	//creation of a ressource TempSensor 
	TempSensor TempSens = new TempSensor() ;
			
	
	//**************************** METHODS ****************************

	@GetMapping("getTemp/")
	public double getTemp() {
		return TempSens.getTemp_value();
	}
	
	@GetMapping("setTemp/{temperature}")
	public double setTemp(@PathVariable double temperature) {
		TempSens.setTemp_value(temperature);
	return TempSens.getTemp_value();
	}
	
}
