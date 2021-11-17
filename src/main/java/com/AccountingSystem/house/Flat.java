package com.AccountingSystem.house;

public class Flat {
    private int countOfHumans;
    private int countOfRooms;
    private double square;
    private double price;
    private int numberOfFlat;

    Flat() {
        countOfHumans = 0;
        countOfRooms = 0;
        square = 0;
        price = 0;
        numberOfFlat = 0;
    }
    Flat(int newCountOfHumans, int newCountOfRooms, double newSquare, int newPrice, int newNumberOfFlat) {
        countOfHumans = newCountOfHumans;
        countOfRooms = newCountOfRooms;
        square = newSquare;
        price = newPrice;
        numberOfFlat = newNumberOfFlat;
    }

    public int getCountOfHumans() {
        return countOfHumans;
    }
    public int getCountOfRooms() {
        return countOfRooms;
    }
    public double getSquare() {
        return square;
    }
    public double getPrice() {
        return price;
    }
    public int getNumberOfFlat() {
        return numberOfFlat;
    }
    public void setCountOfHumans(int newCountOfHumans) {
        countOfHumans = newCountOfHumans;
    }
    public void setCountOfRooms(int newCountOfRooms) {
        countOfRooms = newCountOfRooms;
    }
    public void setSquare(double newSquare) {
        square = newSquare;
    }
    public void setPrice(double newPrice) {
        price = newPrice;
    }
}
