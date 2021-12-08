package com.AccountingSystem.services.builder.houseBuilder;

import com.AccountingSystem.house.House;
import com.AccountingSystem.services.builder.ConstantsForRandomGeneration;

import java.util.Random;

public class HouseManager {
    public static House getHouseWithElevator(HouseBuilder builder, int numberOfHouse, int maxElevatorLoad, int elevatorSpeed){
        builder.setNumberOfHouse(numberOfHouse);
        builder.setElevator(maxElevatorLoad, elevatorSpeed);
        return builder.getHouse();
    }
    public static House getHouseWithParking(HouseBuilder builder, int numberOfHouse, int maxCountOfCars){
        builder.setNumberOfHouse(numberOfHouse);
        builder.setParking(maxCountOfCars);
        return builder.getHouse();
    }
    public static House getHouseWithElevatorAndParking(HouseBuilder builder, int numberOfHouse, int maxElevatorLoad, int elevatorSpeed, int maxCountOfCars){
        builder.setNumberOfHouse(numberOfHouse);
        builder.setElevator(maxElevatorLoad, elevatorSpeed);
        builder.setParking(maxCountOfCars);
        return builder.getHouse();
    }
    public static House getSimpleHouse(HouseBuilder builder, int numberOfHouse){
        builder.setNumberOfHouse(numberOfHouse);
        builder.getHouse();
        return builder.getHouse();
    }
    public static House getRandomHouse(HouseBuilder builder, int numberOfHouse){
        Random rand = new Random();
        ConstantsForRandomGeneration c = new ConstantsForRandomGeneration();
        builder.setNumberOfHouse(numberOfHouse);
        boolean flag = rand.nextBoolean();
        if (flag){
            builder.setParking(rand.nextInt(c.getMAX_CARS_COUNT() - c.getMIN_CARS_COUNT()) + 1 + c.getMIN_CARS_COUNT());
        }
        flag = rand.nextBoolean();
        if(flag) {
            double tempSpeed = rand.nextDouble(c.getMAX_ELEVATOR_SPEED() - c.getMIN_ELEVATOR_SPEED()) + c.getMIN_ELEVATOR_SPEED();
            int tempMaxLoad = rand.nextInt(c.getMAX_ELEVATOR_LOAD() - c.getMIN_ELEVATOR_LOAD() + 1) + c.getMIN_ELEVATOR_LOAD();
            builder.setElevator(tempMaxLoad, tempSpeed);
        }
        return builder.getHouse();
    }
}
