package com.AccountingSystem.services.builder.flatBuilder;

import com.AccountingSystem.house.Flat;
import com.AccountingSystem.services.builder.ConstantsForRandomGeneration;
import java.util.Random;

public class FlatManager {
    public static Flat getSimpleFlat(int numberOfFlat){
        FlatBuilder flatBuilder = FlatBuilder.getFlatBuilder();
        flatBuilder.setNumberOfFlat(numberOfFlat);
        return flatBuilder.getFlat();
    }
    public static Flat getRandomFlat(int numberOfFlat){
        FlatBuilder flatBuilder = FlatBuilder.getFlatBuilder();
        Random rand = new Random();
        ConstantsForRandomGeneration c = new ConstantsForRandomGeneration();

        flatBuilder.setPrice(rand.nextInt(c.getMAX_FLAT_PRICE() - c.getMIN_FLAT_PRICE() + 1) + c.getMIN_FLAT_PRICE());
        double tempSquare = rand.nextDouble(c.getMAX_FLAT_SQUARE() - c.getMIN_FLAT_SQUARE());
        flatBuilder.setSquare(tempSquare);
        flatBuilder.setCountOfHumans(rand.nextInt(c.getMAX_COUNT_OF_PEOPLE()));
        flatBuilder.setCountOfRooms(rand.nextInt(c.getMAX_COUNT_OF_ROOMS()) + 1);
        boolean flag = rand.nextBoolean();
        if(flag){
            double maxPoolVolume = tempSquare * c.getMAX_POOL_POSSIBLE_VOLUME();
            double minPoolVolume = tempSquare * c.getMIN_POOL_POSSIBLE_VOLUME();
            double tempDepth = rand.nextDouble(c.getMAX_POOL_DEPTH() - c.getMIN_POOL_DEPTH()) + c.getMIN_POOL_DEPTH();
            double tempVolume = rand.nextDouble(maxPoolVolume - minPoolVolume) + minPoolVolume;
            flatBuilder.setSwimmingPool(tempDepth, tempVolume);
        }
        else{
            flatBuilder.setSwimmingPool(0,0);
        }
        flag = rand.nextBoolean();
        if(flag){
            double maxTerraceSquare = tempSquare * c.getMAX_TERRACE_POSSIBLE_SQUARE();
            double minTerraceSquare = tempSquare * c.getMIN_TERRACE_POSSIBLE_SQUARE();
            flatBuilder.setTerrace(rand.nextDouble(maxTerraceSquare - minTerraceSquare) + minTerraceSquare);
        }
        else{
            flatBuilder.setTerrace(0);
        }
        flatBuilder.setNumberOfFlat(numberOfFlat);
        return flatBuilder.getFlat();
    }
    public static Flat getFlat(int numberOfFlat, double square){
        FlatBuilder flatBuilder = FlatBuilder.getFlatBuilder();
        flatBuilder.setZeros();
        Random rand = new Random();
        ConstantsForRandomGeneration c = new ConstantsForRandomGeneration();
        boolean flag;
        double poolSquare = 0;
        double terraceSquare = 0;
        flatBuilder.setNumberOfFlat(numberOfFlat);
        flatBuilder.setSquare(square);
        flag = rand.nextBoolean();
        if(flag){
            double maxPoolVolume = square * c.getMAX_POOL_POSSIBLE_VOLUME();
            double minPoolVolume = square * c.getMIN_POOL_POSSIBLE_VOLUME();
            double tempDepth = rand.nextDouble(c.getMAX_POOL_DEPTH() - c.getMIN_POOL_DEPTH()) + c.getMIN_POOL_DEPTH();
            double tempVolume = rand.nextDouble(maxPoolVolume - minPoolVolume) + minPoolVolume;
            flatBuilder.setSwimmingPool(tempDepth, tempVolume);
            poolSquare = tempVolume/tempDepth;
        } else {
            flatBuilder.setSwimmingPool(0,0);
        }
        flag = rand.nextBoolean();
        if(flag){
            double maxTerraceSquare = square * c.getMAX_TERRACE_POSSIBLE_SQUARE();
            double minTerraceSquare = square * c.getMIN_TERRACE_POSSIBLE_SQUARE();
            terraceSquare = rand.nextDouble(maxTerraceSquare - minTerraceSquare) + minTerraceSquare;
            flatBuilder.setTerrace(terraceSquare);
        } else{
            flatBuilder.setTerrace(0);
        }
        flatBuilder.setCountOfHumans(rand.nextInt((int) (square/c.getSQUARE_FOR_PERSON())));
        double Price = (square-poolSquare) * c.getPRICE_FOR_M2() + poolSquare*c.getPRICE_FOR_M2()*1.1; //Price of m2 of swimming pool = 1.1 PRICE_FOR_M2
        flatBuilder.setPrice((int) Price);
        flatBuilder.setCountOfRooms((int) (square/c.getMIN_SQUARE_OF_ROOM()));
        return flatBuilder.getFlat();
    }
}