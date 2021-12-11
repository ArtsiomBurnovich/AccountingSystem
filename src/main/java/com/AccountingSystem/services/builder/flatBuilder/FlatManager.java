package com.AccountingSystem.services.builder.flatBuilder;

import com.AccountingSystem.house.Flat;
import com.AccountingSystem.services.builder.ConstantsForRandomGeneration;
import java.util.Random;

public class FlatManager {
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
    public Flat getFlat(FlatBuilder builder, int numberOfFlat, double square){
        Random rand = new Random();
        ConstantsForRandomGeneration c = new ConstantsForRandomGeneration();
        boolean flag;
        double poolSquare = 0;
        double terraceSquare = 0;
        builder.setZeros();
        builder.setNumberOfFlat(numberOfFlat);
        builder.setSquare(square);
        flag = rand.nextBoolean();
        if(flag){
            double maxPoolVolume = square * c.getMAX_POOL_POSSIBLE_VOLUME();
            double minPoolVolume = square * c.getMIN_POOL_POSSIBLE_VOLUME();
            double tempDepth = rand.nextDouble(c.getMAX_POOL_DEPTH() - c.getMIN_POOL_DEPTH()) + c.getMIN_POOL_DEPTH();
            double tempVolume = rand.nextDouble(maxPoolVolume - minPoolVolume) + minPoolVolume;
            builder.setSwimmingPool(tempDepth, tempVolume);
            poolSquare = tempVolume/tempDepth;
        }
        flag = rand.nextBoolean();
        if(flag){
            double maxTerraceSquare = square * c.getMAX_TERRACE_POSSIBLE_SQUARE();
            double minTerraceSquare = square * c.getMIN_TERRACE_POSSIBLE_SQUARE();
            terraceSquare = rand.nextDouble(maxTerraceSquare - minTerraceSquare) + minTerraceSquare;
            builder.setTerrace(terraceSquare);
        }
        builder.setCountOfHumans(rand.nextInt((int) (square/c.getSQUARE_FOR_PERSON())));
        double Price = (square-poolSquare) * c.getPRICE_FOR_M2() + poolSquare*c.getPRICE_FOR_M2()*1.1; //Price of m2 of swimming pool = 1.1 PRICE_FOR_M2
        builder.setPrice((int) Price);
        builder.setCountOfRooms((int) (square/c.getMIN_SQUARE_OF_ROOM()));
        return builder.getFlat();
    }
}