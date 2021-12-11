package com.AccountingSystem.services.builder.houseBuilder;

import com.AccountingSystem.house.House;
import com.AccountingSystem.house.facilities.houseFacilities.*;

public class HouseBuilder {
    private int countOfFloors = 0;
    private int numberOfHouse = 0;
    private Elevator elevator = null;
    private Parking parking = null;


    public void setNumberOfHouse(int numberOfHouse) {
        this.numberOfHouse = numberOfHouse;
    }

    public void setElevator(int maxElevatorLoad, double elevatorSpeed) {
        this.elevator = new Elevator(elevatorSpeed, maxElevatorLoad);
    }

    public void setParking(int maxCountOfCars) {

        this.parking = new Parking(maxCountOfCars);
    }

    public House getHouse(){
        return new House(countOfFloors, numberOfHouse, elevator, parking);
    }

    public void setZeros(){
        this.countOfFloors = 0;
        this.numberOfHouse = 0;
        this.elevator = null;
        this.parking = null;
    }
}
