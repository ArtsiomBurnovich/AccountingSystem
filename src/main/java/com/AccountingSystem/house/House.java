package com.AccountingSystem.house;

import com.AccountingSystem.house.facilities.houseFacilities.*;
import java.util.ArrayList;
import java.util.List;

public class House {
    private int countOfFloors;
    private int numberOfHouse;
    private Elevator elevator;
    private Parking parking;
    private List<Floor> floors = new ArrayList<>();

    public House(){
        countOfFloors = 0;
        numberOfHouse = 0;
        elevator = null;
        parking = null;
    }
    House(int numberOfHouse){
        numberOfHouse = numberOfHouse;
    }
    public House(int countOfFloors, int numberOfHouse, Elevator elevator, Parking parking){
        this.countOfFloors = countOfFloors;
        this.numberOfHouse = numberOfHouse;
        this.elevator = elevator;
        this.parking = parking;
    }

    public int getCountOfFloors(){
        return floors.size();
    }
    public int getNumberOfHouse(){
        return numberOfHouse;
    }
    public Parking getParking(){
        return this.parking;
    }
    public Elevator getElevator(){
        return this.elevator;
    }
    public Floor getFloor(int index){
        return floors.get(index);
    }
    public Floor getFloorDescription(int index){
        Floor tempFloor =  new Floor(floors.get(index).getNumberOfFloor());
        return tempFloor;
    }

    public void setNumberOfHouse(int newNumberOfHouse) {
        numberOfHouse = newNumberOfHouse;
    }
    public void setParking(int maxCountOfCars){
        this.parking.setMaxCountOfCars(maxCountOfCars);
    }
    public void setElevator(int elevatorSpeed, int maxElevatorLoad){
        this.elevator.setElevatorSpeed(elevatorSpeed);
        this.elevator.setMaxLoad(maxElevatorLoad);
    }
    public void addFloor() {
        countOfFloors++;
        floors.add(new Floor(countOfFloors));
    }
}
