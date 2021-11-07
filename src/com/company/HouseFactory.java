package com.company;

public class HouseFactory {

    public static House getHouse(EnumHouses type){
        House toReturn = null;
        switch (type){
            case PARKING -> {
                return new HouseWithParking();
            }
            case ELEVATOR -> {
                return new HouseWithElevator();
            }
            case HELICOPTER -> {
                return new HouseWithHelicopterPlace();
            }
            default -> {
                return null;
            }
        }
    }
}
