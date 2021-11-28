package com.AccountingSystem.services;

import com.AccountingSystem.house.Flat;

public class FlatService {
    public static int compareByCountOfHumans(Flat o1, Flat o2){
        return o1.getCountOfHumans() - o2.getCountOfHumans();
    }
    public static int compareByCountOfRooms(Flat o1, Flat o2){
        return o1.getCountOfRooms() - o2.getCountOfRooms();
    }
    public static double compareByPrice(Flat o1, Flat o2){
        return o1.getPrice() - o2.getPrice();
    }
    public static double compareBySquare(Flat o1, Flat o2){
        return o1.getSquare() - o2.getSquare();
    }
}
