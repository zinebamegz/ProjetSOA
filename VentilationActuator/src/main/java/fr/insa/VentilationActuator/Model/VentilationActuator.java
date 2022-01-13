package fr.insa.VentilationActuator.Model;

public class VentilationActuator {
    private boolean state;

    public VentilationActuator(){
        this.state = false; //turned off by default
    }

    public VentilationActuator(boolean val){
        this.state = val;
    }

    public boolean getV(){
        return this.state;
    }

    public void setV(boolean val){
        this.state = val;
    }
}
