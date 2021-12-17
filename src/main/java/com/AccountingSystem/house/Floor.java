package com.AccountingSystem.house;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Floor floor = (Floor) o;
        return numberOfFloor == floor.numberOfFloor && flatsOnFloor.equals(floor.flatsOnFloor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfFloor, flatsOnFloor);
    }

    public void setNumberOfFloor(int numberOfFloor){
        this.numberOfFloor = numberOfFloor;
    }
}

