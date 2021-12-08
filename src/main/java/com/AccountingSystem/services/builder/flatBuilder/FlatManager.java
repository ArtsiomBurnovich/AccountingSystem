package com.AccountingSystem.services.builder.flatBuilder;

import com.AccountingSystem.house.Flat;
import com.AccountingSystem.services.builder.ConstantsForRandomGeneration;
import java.util.Random;

public class FlatManager {
    public Flat getFlatWithTerrace(FlatBuilder builder, int numberOfFlat, double squareOfTerrace){
        builder.setNumberOfFlat(numberOfFlat);
        builder.setTerrace(squareOfTerrace);
        return builder.getFlat();
    }
    public Flat getFlatWithSwimmingPool(FlatBuilder builder, int numberOfFlat, double maxDepth, double volume){
        builder.setNumberOfFlat(numberOfFlat);
        builder.setSwimmingPool(maxDepth, volume);
        return builder.getFlat();
    }
    public Flat getFlatWithTerraceAndSwimmingPool(FlatBuilder builder, int numberOfFlat, double squareOfTerrace, double maxDepth, double volume){
        builder.setNumberOfFlat(numberOfFlat);
        builder.setTerrace(squareOfTerrace);
        builder.setSwimmingPool(maxDepth, volume);
        return builder.getFlat();
    }
    public Flat getSimpleFlat(FlatBuilder builder, int numberOfFlat){
        builder.setNumberOfFlat(numberOfFlat);
        return builder.getFlat();
    }
    public Flat getRandomFlat(FlatBuilder builder, int numberOfFlat){
        Random rand = new Random();
        ConstantsForRandomGeneration c = new ConstantsForRandomGeneration();

        builder.setPrice(rand.nextInt(c.getMAX_FLAT_PRICE() - c.getMIN_FLAT_PRICE() + 1) + c.getMIN_FLAT_PRICE());
        double tempSquare = rand.nextDouble(c.getMAX_FLAT_SQUARE() - c.getMIN_FLAT_SQUARE()) ;
        builder.setSquare(tempSquare);
        builder.setCountOfHumans(rand.nextInt(c.getMAX_COUNT_OF_PEOPLE()));
        builder.setCountOfRooms(rand.nextInt(c.getMAX_COUNT_OF_ROOMS()) + 1);
        boolean flag = rand.nextBoolean();
        if(flag){
            double maxPoolVolume = tempSquare * c.getMAX_POOL_POSSIBLE_VOLUME();
            double minPoolVolume = tempSquare * c.getMIN_POOL_POSSIBLE_VOLUME();
            double tempDepth = rand.nextDouble(c.getMAX_POOL_DEPTH() - c.getMIN_POOL_DEPTH()) + c.getMIN_POOL_DEPTH();
            double tempVolume = rand.nextDouble(maxPoolVolume - minPoolVolume) + minPoolVolume;
            builder.setSwimmingPool(tempDepth, tempVolume);
        }
        flag = rand.nextBoolean();
        if(flag){
            double maxTerraceSquare = tempSquare * c.getMAX_TERRACE_POSSIBLE_SQUARE();
            double minTerraceSquare = tempSquare * c.getMIN_TERRACE_POSSIBLE_SQUARE();
            builder.setTerrace(rand.nextDouble(maxTerraceSquare - minTerraceSquare) + minTerraceSquare);
        }
        builder.setNumberOfFlat(numberOfFlat);
        return builder.getFlat();
    }
}