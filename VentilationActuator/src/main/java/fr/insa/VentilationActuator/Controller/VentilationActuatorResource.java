package fr.insa.VentilationActuator.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.insa.VentilationActuator.Model.VentilationActuator;

@RestController
@RequestMapping("/VentilationActuator")
public class VentilationActuatorResource{
    
    VentilationActuator ventilation = new VentilationActuator();

    @GetMapping("/state")
    public boolean state(){
        return ventilation.getV();
    }

    @GetMapping("/set/{value}")
    public void setVentilationState(@PathVariable boolean value){
        ventilation.setV(value);
    }

}