package fr.insa.VentillationActuator.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.VentillationActuator.Model.VentillationActuator;

import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/VentilationActuator")
public class VentillationActuatorResource{
    
    VentillationActuator ventilation = new VentillationActuator();

    @GetMapping("/getVentilationState")
    public boolean getVentilationState(){
        return ventilation.getVentilationState();
    }

    @GetMapping("/setVentilationState/{activate}")
    public boolean setVentilationState(@PathVariable boolean activate){
    	ventilation.setVentilationState(activate);
        return ventilation.getVentilationState();
    }

    //set air quality to reach
}
