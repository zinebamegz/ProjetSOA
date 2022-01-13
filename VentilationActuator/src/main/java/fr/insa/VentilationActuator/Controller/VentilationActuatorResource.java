package fr.insa.VentilationActuator.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.insa.VentilationActuator.Model.VentilationActuator;

@RestController
@RequestMapping("/VentilationActuator")
public class VentilationActuatorResource{
    
    VentilationActuator ventilation = new VentilationActuator();

    @GetMapping("/getVentilationState")
    public boolean getVentilationState(){
        return ventilation.getVentilationState();
    }

    @GetMapping("/setVentilationON")
    public void setVentilationStateON(){
        ventilation.setVentilationState(true);
    }

    @GetMapping("/setVentilationOFF")
    public void setVentilationStateOFF(){
        ventilation.setVentilationState(false);
    }

}