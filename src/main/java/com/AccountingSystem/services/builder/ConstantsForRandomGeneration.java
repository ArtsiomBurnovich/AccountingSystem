package com.AccountingSystem.services.builder;

public class ConstantsForRandomGeneration {
    private int MAX_COUNT_OF_PEOPLE = 10;

    private double MIN_FLAT_SQUARE = 10;
    private double MAX_FLAT_SQUARE = (int) 1e4;

    private int MIN_FLAT_PRICE = (int) 1e4;
    private int MAX_FLAT_PRICE = (int) 1e6;

    private int MAX_COUNT_OF_ROOMS = 20;

    private double MIN_POOL_DEPTH = 0.2;
    private double MAX_POOL_DEPTH = 3;

    private double MAX_POOL_POSSIBLE_VOLUME = 0.07;
    private double MIN_POOL_POSSIBLE_VOLUME = 0.02;

    private double MAX_TERRACE_POSSIBLE_SQUARE = 0.07;
    private double MIN_TERRACE_POSSIBLE_SQUARE = 0.02;

    private double MIN_ELEVATOR_SPEED = 0.5;
    private double MAX_ELEVATOR_SPEED = 10;

    private int MIN_ELEVATOR_LOAD = 150;
    private int MAX_ELEVATOR_LOAD = 2000;

    private int MIN_CARS_COUNT = 10;
    private int MAX_CARS_COUNT = 1000;



    public int getMAX_COUNT_OF_PEOPLE() {
        return MAX_COUNT_OF_PEOPLE;
    }

    public double getMIN_FLAT_SQUARE() {
        return MIN_FLAT_SQUARE;
    }

    public double getMAX_FLAT_SQUARE() {
        return MAX_FLAT_SQUARE;
    }

    public int getMIN_FLAT_PRICE() {
        return MIN_FLAT_PRICE;
    }

    public int getMAX_FLAT_PRICE() {
        return MAX_FLAT_PRICE;
    }

    public int getMAX_COUNT_OF_ROOMS() {
        return MAX_COUNT_OF_ROOMS;
    }

    public double getMIN_POOL_DEPTH() {
        return MIN_POOL_DEPTH;
    }

    public double getMAX_POOL_DEPTH() {
        return MAX_POOL_DEPTH;
    }

    public double getMAX_POOL_POSSIBLE_VOLUME() {
        return MAX_POOL_POSSIBLE_VOLUME;
    }

    public double getMIN_POOL_POSSIBLE_VOLUME() {
        return MIN_POOL_POSSIBLE_VOLUME;
    }

    public double getMAX_TERRACE_POSSIBLE_SQUARE() {
        return MAX_TERRACE_POSSIBLE_SQUARE;
    }

    public double getMIN_TERRACE_POSSIBLE_SQUARE() {
        return MIN_TERRACE_POSSIBLE_SQUARE;
    }

    public double getMIN_ELEVATOR_SPEED() {
        return MIN_ELEVATOR_SPEED;
    }

    public double getMAX_ELEVATOR_SPEED() {
        return MAX_ELEVATOR_SPEED;
    }

    public int getMIN_CARS_COUNT() {
        return MIN_CARS_COUNT;
    }

    public int getMAX_CARS_COUNT() {
        return MAX_CARS_COUNT;
    }

    public int getMIN_ELEVATOR_LOAD() {
        return MIN_ELEVATOR_LOAD;
    }

    public int getMAX_ELEVATOR_LOAD() {
        return MAX_ELEVATOR_LOAD;
    }
}

