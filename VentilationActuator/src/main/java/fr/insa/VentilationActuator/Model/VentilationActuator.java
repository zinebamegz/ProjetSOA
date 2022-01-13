package fr.insa.VentilationActuator.Model;

public class VentilationActuator {
    private boolean active;
    //private int airQualityToReach = 20; //default

    //----------Constructors--------------

    public VentilationActuator(){
        this.active = false; //turned off by default
    }

    public VentilationActuator(boolean val){
        this.active = val;
    }

    //------------Methods---------------

    public boolean getVentilationState(){
        return this.active;
    }

    public void setVentilationState(boolean val){
        this.active = val;
    }
}
