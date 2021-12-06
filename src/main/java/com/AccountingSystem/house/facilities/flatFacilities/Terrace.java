package com.AccountingSystem.house.facilities.flatFacilities;

public class Terrace {
    private double terraceSquare;

    Terrace(){
        terraceSquare = 0;
    }
    Terrace(double terraceSquare){
        this.terraceSquare = terraceSquare;
    }

    public void setTerraceSquare(double terraceSquare){
        this.terraceSquare = terraceSquare;
    }
    public double getTerraceSquare(){
        return this.terraceSquare;
    }
}
