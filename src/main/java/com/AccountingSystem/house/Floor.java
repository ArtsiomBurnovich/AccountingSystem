package com.AccountingSystem.house;
import java.util.ArrayList;
import java.util.List;


public class Floor {
    private int numberOfFloor = 0;
    private List<Flat> flatsOnFloor = new ArrayList();

    public Floor (){
        numberOfFloor = 0;
    }
    public Floor(int newNumberOfFloor){
        numberOfFloor = newNumberOfFloor;
    }

    public void addFlat(Flat flat) {
        flatsOnFloor.add(flat);
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

    public void setNumberOfFloor(int numberOfFloor){
        this.numberOfFloor = numberOfFloor;
    }
}

