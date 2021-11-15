package com.AccountingSystem.house;
import java.util.ArrayList;
import java.util.List;

public class House {
    private int countOfFloors;
    private int countOfFlats;
    private int numberOfHouse;
    protected String name;
    private List<Floor> floors = new ArrayList<>();

    House(){
        countOfFloors = 0;
        countOfFlats = 0;
        numberOfHouse = 0;
    }
    House(int numberOfHouse){
        numberOfHouse = numberOfHouse;
    }
    public int getCountOfFloors(){
        return countOfFloors;
    }
    public int getCountOfFlats(){
        return countOfFlats;
    }
    public int getNumberOfHouse(){
        return numberOfHouse;
    }
    public void setNumberOfHouse(int newNumberOfHouse) {
        numberOfHouse = newNumberOfHouse;
    }
    public void setCountOfFlats(int newCountOfFlats){
        countOfFlats = newCountOfFlats;
    }
    public void addFloor() {
        countOfFloors++;
        floors.add(new Floor(countOfFloors));
    }
    public Floor getFloor(int index){
        return floors.get(index);
    }
    public String getName(){
        return name;
    }

}
