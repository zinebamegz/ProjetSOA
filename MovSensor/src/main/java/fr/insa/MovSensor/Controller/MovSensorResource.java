package fr.insa.MovSensor.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.MovSensor.Model.MovSensor;

@RestController
@RequestMapping("/MovSensor/")

public class MovSensorResource {
	MovSensor MovementSensor = new MovSensor(); 
	
	/*Get state of the sensor 
	 * True = detected (Someone is IN) 
	 * False = no detection
	*/
		@GetMapping("/isIN")
		public boolean getMotion() {
			return MovementSensor.getMotion();
		}

		
		/*Make the sensor detect or ignore motion (true or false) and return it*/
		@GetMapping("/detect/{motion}")
		public boolean  setMotion(@PathVariable boolean motion) {
			MovementSensor.setMotion(motion);
				return MovementSensor.getMotion();
		}
}
