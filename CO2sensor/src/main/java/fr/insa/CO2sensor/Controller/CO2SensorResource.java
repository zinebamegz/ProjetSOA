package fr.insa.CO2sensor.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.insa.CO2sensor.Model.CO2Sensor;

@RestController
@RequestMapping("/CO2Sensor")
public class CO2SensorResource {

    CO2Sensor CO2Sensor = new CO2Sensor();

    @GetMapping("/getCO2Value")
    public int getCO2Level(){
        return CO2Sensor.getCO2Level();
    }

    @GetMapping("/setCO2Value/{CO2Level}")
    public String setCO2Level(@PathVariable int CO2Level){
    	String message ="CO2 level set to " + CO2Level +""+ CO2Sensor.getCO2Unit(); 
        CO2Sensor.setCO2Level(CO2Level);
        return message; 
    }

    @GetMapping("/getCO2Unit")
    public String getCO2Unit(){
        return CO2Sensor.getCO2Unit();
    }

    @GetMapping("/setCO2Unit/{CO2Unit}")
    public String setCO2Unit(@PathVariable String CO2Unit){
    	String message ="CO2 Unit set to " + CO2Unit; 
        CO2Sensor.setCO2Unit(CO2Unit);
        return message; 
    }

}
