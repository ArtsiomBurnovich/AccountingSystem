package com.AccountingSystem.services.builder.houseBuilder;

public class HouseManager {
    public static void getHouseWithElevator(HouseBuilder builder, int numberOfHouse, int maxElevatorLoad, int elevatorSpeed){
        builder.setNumberOfHouse(numberOfHouse);
        builder.setElevator(maxElevatorLoad, elevatorSpeed);
    }
    public static void getHouseWithParking(HouseBuilder builder, int numberOfHouse, int maxCountOfCars){
        builder.setNumberOfHouse(numberOfHouse);
        builder.setParking(maxCountOfCars);
    }
    public static void getHouseWithElevatorAndParking(HouseBuilder builder, int numberOfHouse, int maxElevatorLoad, int elevatorSpeed, int maxCountOfCars){
        builder.setNumberOfHouse(numberOfHouse);
        builder.setElevator(maxElevatorLoad, elevatorSpeed);
        builder.setParking(maxCountOfCars);
    }
    public static void getSimpleHouse(HouseBuilder builder, int numberOfHouse){
        builder.setNumberOfHouse(numberOfHouse);
    }

}
