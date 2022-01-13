package fr.insa.LightActuator.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.LightActuator.Model.LightActuator;

@RestController
@RequestMapping("/LightActuator/")
public class LightActuatorResource {
	
	/*Return the state of the lights if ON true else false */ 
		@GetMapping("/isON")
		public boolean isON() {
			LightActuator lights = new LightActuator(); 
			return lights.getState();
		}

		
		/*Turn ON or OFF the lights*/
		@GetMapping("/setLight/{etat}")
		public LightActuator  setLight(@PathVariable boolean etat) {		
			LightActuator lights = new LightActuator(etat); 
			
			if (Boolean.TRUE.equals(etat)) { 
				return lights;
			}else {
				return lights;
			}
		}
		
}
