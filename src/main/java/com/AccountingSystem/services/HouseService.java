package com.AccountingSystem.services;

import com.AccountingSystem.house.*;

public class HouseService {
    public static int compareByNumber(House o1, House o2){
        return o1.getNumberOfHouse() - o2.getNumberOfHouse();
    }
    public static double compareBySquare(House o1, House o2){
        return calculateSquare(o1) - calculateSquare(o2);
    }
    public static double compareByPrice(House o1, House o2){
        return calculatePrice(o1) - calculatePrice(o2);
    }
    public static int compareByCountOfHumans(House o1, House o2){
        return calculateHumans(o1) - calculateHumans(o2);
    }
    public static int compareByCountOfFlats(House o1, House o2){
        return o1.getCountOfFlats() - o2.getCountOfFlats();
    }

    public static int calculateHumans(House o){
        int temp = 0;
        for (int i = 0; i < o.getCountOfFloors(); i++)
        {
            for (int j = 0; j < o.getFloor(i).getCountOfFlatsOnFloor(); j++)
            {
                temp += o.getFloor(i).getFlat(j).getCountOfHumans();
            }
        }
        return temp;
    }
    public static double calculateSquare(House o){
        int temp = 0;
        for (int i = 0; i < o.getCountOfFloors(); i++)
        {
            for (int j = 0; j < o.getFloor(i).getCountOfFlatsOnFloor(); j++)
            {
                temp += o.getFloor(i).getFlat(j).getSquare();
            }
        }
        return temp;
    }
    public static double calculatePrice(House o){
        int temp = 0;
        for (int i = 0; i < o.getCountOfFloors(); i++)
        {
            for (int j = 0; j < o.getFloor(i).getCountOfFlatsOnFloor(); j++)
            {
                temp += o.getFloor(i).getFlat(j).getPrice();
            }
        }
        return temp;
    }
    public static void printHouse(House o){
        System.out.println("House " + o.getNumberOfHouse());
        System.out.println("Parking (count of car places): " + o.getParking().getMaxCountOfCars());
        System.out.println("Elevator (max speed (m/s), max load(kg): " + o.getElevator().getElevatorSpeed() + ", " + o.getElevator().getMaxLoad());
        for (int i = 0; i < o.getCountOfFloors(); i++)
        {
            System.out.println("Floor: " + (i+1));
            FloorService.printFloor(o.getFloor(i));
        }
    }
}
