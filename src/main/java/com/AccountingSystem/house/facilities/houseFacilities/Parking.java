package com.AccountingSystem.house.facilities.houseFacilities;

public class Parking {
    private int maxCountOfCars;

    public Parking(){
        this.maxCountOfCars = 0;
    }
    public Parking(int maxCountOfCars){
        this.maxCountOfCars = maxCountOfCars;
    }

    public int getMaxCountOfCars() {
        return maxCountOfCars;
    }
    public void setMaxCountOfCars(int maxCountOfCars) {
        this.maxCountOfCars = maxCountOfCars;
    }
}
