package com.AccountingSystem.services.builder.houseBuilder;

import com.AccountingSystem.house.House;
import com.AccountingSystem.house.facilities.houseFacilities.*;

public class HouseBuilder {
    private int countOfFloors = 0;
    private int countOfFlats = 0;
    private int numberOfHouse = 0;
    private Elevator elevator = null;
    private Parking parking = null;

    public void setCountOfFlats(int countOfFlats) {
        this.countOfFlats = countOfFlats;
    }

    public void setCountOfFloors(int countOfFloors) {
        this.countOfFloors = countOfFloors;
    }

    public void setNumberOfHouse(int numberOfHouse) {
        this.numberOfHouse = numberOfHouse;
    }

    public void setElevator(int maxElevatorLoad, int elevatorSpeed) {
        this.elevator.setElevatorSpeed(elevatorSpeed);
        this.elevator.setMaxLoad(maxElevatorLoad);
    }

    public void setParking(int maxCountOfCars) {
        this.parking.setMaxCountOfCars(maxCountOfCars);;
    }

    public House getHouse(){
        return new House(countOfFloors, countOfFlats, numberOfHouse, elevator, parking);
    }
}
