package fr.insa.VentillationActuator.Model;

public class VentillationActuator {
    private boolean active;
    //private int airQualityToReach = 20; //default

    //----------Constructors--------------

    public VentillationActuator(){
        this.active = false; //turned off by default
    }

    public VentillationActuator(boolean val){
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
