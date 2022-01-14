package fr.insa.HeaterActuator.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import fr.insa.HeaterActuator.Model.HeaterActuator;

@RestController
@RequestMapping("/HeaterActuator/")
public class HeaterActuatorRessource {
		
	//creation of a ressource heater 
	HeaterActuator heater = new HeaterActuator() ;
		
	
	//**************************** METHODS ****************************
	
	//return if the heater is active or not
	@GetMapping("isActive/") 
	public boolean isActive() {
		return heater.getActive();
	}
	
	
	//put on or off the heater according to a boolean parameter
	@GetMapping("putHeaterOnOff/{OnOff}") 
	public void putHeaterOnOff(@PathVariable boolean OnOff) {
		heater.setActive(OnOff);
	}

	
	//return the temperature to be reach
	@GetMapping("getTemperatureToReach/") 
	public double getTemperatureToReach() { 
		return heater.getTemperatureToReach();
	}

	
	//set the temperature to be reach
	@GetMapping("setTemperatureToReach/{temp}")
	public void setTemperatureToReach(@PathVariable double temp) {
		heater.setTemperatureToReach(temp);
	}
}
