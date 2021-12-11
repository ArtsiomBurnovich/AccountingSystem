package com.AccountingSystem.house.facilities.flatFacilities;

public class Terrace {
    private double terraceSquare;

    public Terrace(){
        terraceSquare = 0;
    }
    public Terrace(double terraceSquare){
        this.terraceSquare = terraceSquare;
    }

    public void setTerraceSquare(double terraceSquare){
        this.terraceSquare = terraceSquare;
    }
    public double getTerraceSquare(){
        return this.terraceSquare;
    }
}
