package com.AccountingSystem.house;
import java.util.ArrayList;
import java.util.List;


public class Floor {
    private int numberOfFloor = 0;
    private List<Flat> flatsOnFloor = new ArrayList();

    Floor(int newNumberOfFloor){
        numberOfFloor = newNumberOfFloor;
    }

    public void addFlat(int newCountOfHumans, int newCountOfRooms, double newSquare, int newPrice, int newNumberOfFlat) {
        flatsOnFloor.add(new Flat(newCountOfHumans, newCountOfRooms, newSquare, newPrice, newNumberOfFlat));

    }
    public Flat getFlat(int index) {
        return flatsOnFloor.get(index);
    }
    public int getCountOfFlatsOnFloor(){
        return flatsOnFloor.size();
    }
    public int getNumberOfFloor(){
        return numberOfFloor;
    }
}

