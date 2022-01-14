package fr.insa.LightActuator.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.LightActuator.Model.LightActuator;

@RestController
@RequestMapping("/LightActuator/")
public class LightActuatorResource {
	
	LightActuator lights = new LightActuator();
	
	/*Return the state of the lights if ON true else false */ 
		@GetMapping("isON")
		public boolean isON() {
			return lights.getState();
		}
		
		/*Turn ON or OFF the lights and return what state it's in*/
		@GetMapping("setLight/{state}")
		public boolean setLight(@PathVariable boolean state) {
			lights.setState(state);
				return lights.getState();
		}
		
}
