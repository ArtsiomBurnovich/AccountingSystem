package com.AccountingSystem.services.builder.flatBuilder;

import com.AccountingSystem.house.facilities.flatFacilities.*;
import com.AccountingSystem.house.Flat;

public class FlatBuilder {
    private int countOfHumans = 0;
    private int countOfRooms = 0;
    private double square = 0;
    private double price = 0;
    private SwimmingPool swimmingPool = null;
    private Terrace terrace = null;
    private int numberOfFlat = 0;

    public void setCountOfHumans(int countOfHumans){
        this.countOfHumans = countOfHumans;
    }
    public void setCountOfRooms(int countOfRooms){
        this.countOfRooms = countOfRooms;
    }
    public void setSquare(double square){
        this.square = square;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public void setSwimmingPool(double maxDepth, double volume) {
        this.swimmingPool = new SwimmingPool(maxDepth, volume);
    }
    public void setTerrace(double square){
        this.terrace = new Terrace(square);
    }
    public void setNumberOfFlat(int numberOfFlat){
        this.numberOfFlat = numberOfFlat;
    }
    public void setZeros(){
        this.countOfHumans = 0;
        this.countOfRooms = 0;
        this.square = 0;
        this.price = 0;
        this.numberOfFlat = 0;
        this.swimmingPool = null;
        this.terrace = null;
    }
    public Flat getFlat(){
        return new Flat(countOfHumans, countOfRooms, square, price, numberOfFlat, swimmingPool, terrace);
    }
}
