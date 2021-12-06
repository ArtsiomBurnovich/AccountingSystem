package com.AccountingSystem.house.facilities.houseFacilities;

public class Elevator {
    private double elevatorSpeed;
    private int maxLoad;

    Elevator(){
        this.elevatorSpeed = 0;
        this.maxLoad = 0;
    }
    Elevator(double elevatorSpeed, int maxLoad){
        this.elevatorSpeed = elevatorSpeed;
        this.maxLoad = maxLoad;
    }

    public double getElevatorSpeed() {
        return elevatorSpeed;
    }
    public int getMaxLoad() {
        return maxLoad;
    }
    public void setElevatorSpeed(double elevatorSpeed){
        this.elevatorSpeed = elevatorSpeed;
    }
    public void setMaxLoad(int maxLoad) {
        this.maxLoad = maxLoad;
    }

}
