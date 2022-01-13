package fr.insa.CO2sensor.Model;


public class CO2Sensor {

    //Declaration on the sensor variables
    private int CO2Level;
    private String unit;

    //Constructor
    public CO2Sensor(){

        //Default values attriuted
        this.CO2Level = 30;
        this.unit = "PPM";
    }


    //Methods
    public int getCO2Level(){
        return CO2Level;
    }

    public void setCO2Level(int CO2Level){
        this.CO2Level = CO2Level;
    }

    public String getCO2Unit(){
        return this.unit;
    }

    public void setCO2Unit(String unit){
        this.unit = unit;
    }
}
