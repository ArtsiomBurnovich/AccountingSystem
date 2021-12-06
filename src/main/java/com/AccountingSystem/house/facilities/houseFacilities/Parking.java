package com.AccountingSystem.house.facilities.houseFacilities;

public class Parking {
    private int maxCountOfCars;

    Parking(){
        this.maxCountOfCars = 0;
    }
    Parking(int maxCountOfCars){
        this.maxCountOfCars = maxCountOfCars;
    }

    public int getMaxCountOfCars() {
        return maxCountOfCars;
    }
    public void setMaxCountOfCars(int maxCountOfCars) {
        this.maxCountOfCars = maxCountOfCars;
    }
}
