package fr.insa.CO2sensor.Model;

public class CO2Sensor {
    private int CO2Level;

    public CO2Sensor(int CO2Level){
        this.CO2Level = CO2Level;
    }

    public CO2Sensor(){
    }

    public int getCO2Level(){
        return CO2Level;
    }

    //For simulation
    public void setCO2Level(int CO2Level){
        this.CO2Level = CO2Level;
    }

}
