package com.AccountingSystem.services.builder.houseBuilder;

import com.AccountingSystem.house.House;
import com.AccountingSystem.services.builder.ConstantsForRandomGeneration;
import com.AccountingSystem.services.builder.flatBuilder.FlatBuilder;
import com.AccountingSystem.services.builder.flatBuilder.FlatManager;

import java.util.Random;

public class HouseManager {
    public static House getSimpleHouse(HouseBuilder houseBuilder, int numberOfHouse) {
        houseBuilder.setNumberOfHouse(numberOfHouse);
        return houseBuilder.getHouse();
    }

    public static House getRandomHouse(int numberOfHouse, int countOfFloors, int countOfFlats, double averageSquareOfFlats) {
        HouseBuilder houseBuilder = HouseBuilder.getHouseBuilder();
        FlatBuilder flatBuilder = FlatBuilder.getFlatBuilder();
        houseBuilder.setZeros();
        houseBuilder.setNumberOfHouse(numberOfHouse);
        Random rand = new Random();
        ConstantsForRandomGeneration c = new ConstantsForRandomGeneration();
        FlatManager flatManager = new FlatManager();

        //set parking
        houseBuilder.setParking(countOfFlats);

        //calculating and setting elevator (load and speed)
        if (countOfFloors > 1) {
            double tempElevSpeed = Math.log(countOfFloors) / Math.log(2.0);
            double tempElevLoad = Math.log(countOfFlats) / Math.log(2.0) * 100 + 300;
            houseBuilder.setElevator((int) tempElevLoad, tempElevSpeed);
        } else {
            houseBuilder.setElevator(0, 0);
        }

        //computing and creating house with flats
        int tempCountOfFlatsOnFloor = countOfFlats / countOfFloors;
        int extraFlats = countOfFlats % countOfFloors;
        House house = houseBuilder.getHouse();
        double tempSquare;
        double deltaSquare = 0;
        for (int i = 0; i < countOfFloors; i++) {
            house.addFloor();
        }
        int tempCounter = 1;
        int tempCountOfFlats = 0;
        for (int j = 0; j < countOfFloors; j++) {

            if (j >= countOfFloors - extraFlats) {                //for extra flats
                house.getFloor(j).addFlat(flatManager.getFlat(tempCounter, averageSquareOfFlats));
                tempCountOfFlats++;
                tempCounter++;
            }
            for (int i = 0; i < tempCountOfFlatsOnFloor; i++) {
                if ((i & 1) == 0) {
                    deltaSquare = rand.nextDouble(0.1 * averageSquareOfFlats);
                    if (rand.nextBoolean()) {
                        deltaSquare *= (-1);
                    }
                    tempSquare = averageSquareOfFlats + deltaSquare;
                } else {
                    tempSquare = averageSquareOfFlats - deltaSquare;
                }
                house.getFloor(j).addFlat(flatManager.getFlat(tempCounter, tempSquare));
                tempCountOfFlats++;
                tempCounter++;
            }
        }
        return house;
    }
}


