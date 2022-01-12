package fr.insa.TempSensor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@RequestMapping("/TempSensor/")

public class TempSensorApplication {
	// Variable
	private double temp_value;

	// Constructor
	public TempSensorApplication() {
		this.temp_value = 20; 
	}

	//Methodes
	
	@GetMapping("getTemp/")
	public double getTemp() {
		return temp_value;
	}
	
	@GetMapping(value="/setTemp/{temperature}")
	public void setTemp(@PathVariable double temperature) {
		this.temp_value = temperature;
	}
	
	//Main
	public static void main(String[] args) {
		SpringApplication.run(TempSensorApplication.class, args);
	}
			

}



