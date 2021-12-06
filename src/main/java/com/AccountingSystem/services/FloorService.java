package com.AccountingSystem.services;

import com.AccountingSystem.house.*;

public class FloorService {
    public static int compareByNumber(Floor o1, Floor o2){
        return o1.getNumberOfFloor() - o2.getNumberOfFloor();
    }
    public static double compareBySquare(Floor o1, Floor o2){
        return calculateSquare(o1) - calculateSquare(o2);
    }
    public static double compareByPrice(Floor o1, Floor o2){
        return calculatePrice(o1) - calculatePrice(o2);
    }
    public static int compareByCountOfHumans(Floor o1, Floor o2){
        return calculateHumans(o1) - calculateHumans(o2);
    }
    public static int compareByCountOfFlats(Floor o1, Floor o2){
        return o1.getCountOfFlatsOnFloor() - o2.getCountOfFlatsOnFloor();
    }

    public static int calculateHumans(Floor o){
        int temp = 0;
        for (int i = 0; i < o.getCountOfFlatsOnFloor(); i++) {
            temp += o.getFlat(i).getCountOfHumans();
        }
        return temp;
    }
    public static double calculateSquare(Floor o){
        int temp = 0;
        for (int i = 0; i < o.getCountOfFlatsOnFloor(); i++) {
            temp += o.getFlat(i).getSquare();
        }
        return temp;
    }
    public static double calculatePrice(Floor o){
        int temp = 0;
        for (int i = 0; i < o.getCountOfFlatsOnFloor(); i++) {
            temp += o.getFlat(i).getPrice();
        }
        return temp;
    }

    public static void printFloor(Floor o){
        for (int i = 0; i < o.getCountOfFlatsOnFloor(); i++)
        {
            System.out.println("Flat: " + (i+1));
            FlatService.printFlat(o.getFlat(i));
        }
    }
}
