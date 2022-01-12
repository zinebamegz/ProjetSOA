package fr.insa.Orchestrator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.SpringApplication;

@RestController
@SpringBootApplication
@RequestMapping("/Orchestrator/")
public class OrchestratorApplication {
	//***************************** VARIABLES ***************************
	
	private String TempSensorURI = "http://localhost:8082/TempSensor/";
	private String HeaterActuatorURI = "http://localhost:8093/HeaterActuator/";
	
	
	private double temp; //variable to stock value from temperature sensor
	private double min_temp = 15.0; //minimal temperature for the room
	private double max_temp = 25.0; //maximal temperature for the room
	//**************************** METHODES ****************************
	
	//2nd user story: heating system control
	
	@GetMapping("HeatingControl/")
	public void HeatingControl() {
		
		//retrieve temperature value from TempSensor
		String url_getTemperature = TempSensorURI + "getTemp/";
		RestTemplate restTemplate = new RestTemplate();
		this.temp = restTemplate.getForObject(url_getTemperature,double.class);
		
		
		//if temperature < 15.0, put the heating on
		if (this.temp < this.min_temp) {
		
			String url_setHeater = HeaterActuatorURI + "setActive/?activate=true";
			restTemplate.getForObject(url_setHeater,boolean.class);
						 
		//TO DOOO : simulate the increasing temperature in the room!!!
			
		}
		//TO DO!!
		//if temperature >25.0, put the heating off
		//else if(this.temp > this.max_temp) {
			
		//}
		
		//return this.temp; 
	}
	
	
	
	//*************************** MAIN ***********************************
	
	public static void main(String[] args) {
		SpringApplication.run(OrchestratorApplication.class, args);
	}

}