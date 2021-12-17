package com.AccountingSystem.house;

import com.AccountingSystem.house.facilities.houseFacilities.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return countOfFloors == house.countOfFloors && numberOfHouse == house.numberOfHouse && elevator.equals(house.elevator) && parking.equals(house.parking) && floors.equals(house.floors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countOfFloors, numberOfHouse, elevator, parking, floors);
    }

    public void setNumberOfHouse(int newNumberOfHouse) {
        numberOfHouse = newNumberOfHouse;
    }
    public void setParking(int maxCountOfCars){
        this.parking = new Parking(maxCountOfCars);
    }
    public void setElevator(double elevatorSpeed, int maxElevatorLoad){
        this.elevator = new Elevator(elevatorSpeed, maxElevatorLoad);
    }
    public void addFloor() {
        countOfFloors++;
        floors.add(new Floor(countOfFloors));
    }
}
