package fr.insa.Orchestrator.Controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/Orchestrator")
public class OrchestratorResource {
	//***************************** VARIABLES ***************************
	
	private String TempSensorURI = "http://localhost:8082/TempSensor/";
	private String HeaterActuatorURI = "http://localhost:8093/HeaterActuator/";
		
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
	
	
	//2nd user story: heating system control
	 	@GetMapping("/HeatingControl")
		public String HeatingControl() {
			
			String HeaterON_URL = HeaterActuatorURI + "putHeaterOnOff/true";
			String HeaterOFF_URL = HeaterActuatorURI + "putHeaterOnOff/false";
			String TempToReach_URL = HeaterActuatorURI + "setTemperatureToReach/25.0"; //to change the temperature to reach by the heater, change the double at the end
			
			String TempValue_URL = TempSensorURI + "getTemp/";
			
			double min_temp = 15.0; //minimal temperature for the room
			double max_temp = 25.0; //maximal temperature for the room
			String message ;

			RestTemplate restTemplate = new RestTemplate();
			
			double TempValue = restTemplate.getForObject(TempValue_URL,double.class); // TempValue = the temperature in the room

			
			if (TempValue > max_temp) {
				//if temperature > max_temp => heater OFF
				
				restTemplate.getForObject(HeaterOFF_URL,void.class);
				return message = "Temperature in the room = " + TempValue + " °C > " + max_temp + " °C : too high. Heater turned off." ; 
				
			}else if(TempValue < min_temp){
				//if temperature < min_temp => heater ON
				
				restTemplate.getForObject(HeaterON_URL,void.class);
				return message = "Temperature in the room = " + TempValue + " °C < " + min_temp + " °C : too low. Heater turned on."; 
				
			} else {
				return message = "Temperature in the room = " + TempValue + " °C : between " + min_temp + " and " + max_temp + " °C => OK"; 
			}
		}
	 	
	
	//User Story 7: Ventilation Control
	@GetMapping("/VentilationControl")
	public String VentilationControl(){
		String VentilationON_URL = VentilationURL + "setVentilationState/true";
		String VentilationOFF_URL = VentilationURL + "setVentilationState/false";
		
		String CO2Value_URL = CO2SensorURI + "getCO2Value";
		String CO2Unit_URL = CO2SensorURI + "getCO2Unit";

		String message = "";

		RestTemplate restTemplate = new RestTemplate();
		
		int CO2_level = restTemplate.getForObject(CO2Value_URL,int.class);
		String CO2_unit = restTemplate.getForObject(CO2Unit_URL,String.class);

		if ((CO2_level>20) && (CO2_unit.equals("PPM"))) {
			restTemplate.getForObject(VentilationON_URL,boolean.class);
			return message = "Ventilation ON. CO2 still too high";
			
		}else{
			restTemplate.getForObject(VentilationOFF_URL,boolean.class);
			return message = "Ventilation OFF. CO2 level okay.";
		}
	}

	
	
	
		
}
