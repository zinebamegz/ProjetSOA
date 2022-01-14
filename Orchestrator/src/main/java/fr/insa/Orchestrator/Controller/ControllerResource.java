package fr.insa.Orchestrator.Controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/Orchestrator")
public class ControllerResource {
	//***************************** VARIABLES ***************************
	
	private String TempSensorURI = "http://localhost:8082/TempSensor/";
	private String HeaterActuatorURI = "http://localhost:8093/HeaterActuator/";
	private double temp; //variable to stock value from temperature sensor
	private double min_temp = 15.0; //minimal temperature for the room
	private double max_temp = 25.0; //maximal temperature for the room
	
	private String CO2SensorURI = "http://localhost:8083/CO2Sensor/";
	private String VentilationURL = "http://localhost:8094/VentilationActuator/";
	
	private String LightActuatorURI="http://localhost:8092/LightActuator/";
	private String MovSensorURI ="http://localhost:8081/MovSensor/"; 
	

	//**************************** METHODES ****************************
	
	//First user story : Lights management 
	@GetMapping("/LightControl")
	public String LightControl(){
		String MotionURL = MovSensorURI + "isIN";
		String LightsOnURL = LightActuatorURI + "setLight/true";
		String LightsOffURL = LightActuatorURI + "setLight/false";
		String message; 
		//Instanciate RestTemplate for Rest calls
		RestTemplate restTemplate = new RestTemplate();
		
		if (restTemplate.getForObject(MotionURL,boolean.class)) {
			restTemplate.getForObject(LightsOnURL,boolean.class);
			return message="Lights ON - Movement detected"; 
			
		}else {
			restTemplate.getForObject(LightsOffURL,boolean.class);
			return message="Lights OFF - Movement not detected"; 
		}
	}
	
	
	//User Story 7: Ventilation Control
	@GetMapping("/VentilationControl")
	public String VentilationControl(){
		String VentilationON_URL = VentilationURL + "/setVentilationState/true";
		String VentilationOFF_URL = VentilationURL + "/setVentilationState/false";

		String message = "";

		RestTemplate restTemplate = new RestTemplate();
		
		int CO2_level = restTemplate.getForObject(CO2SensorURI + "/getCO2Value", int.class);
		String CO2_unit = restTemplate.getForObject(CO2SensorURI + "/getCO2Unit", String.class);

		if ((CO2_level > 50) & (CO2_unit == "ppm")) {
			restTemplate.getForObject(VentilationON_URL,void.class);	
			message = "Ventilation ON. CO2 still too high";
		}
		else{
			restTemplate.getForObject(VentilationOFF_URL, int.class);
			message = "Ventilation OFF. CO2 level okay.";
		}
		return message;
	}

	
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
	
		
}
