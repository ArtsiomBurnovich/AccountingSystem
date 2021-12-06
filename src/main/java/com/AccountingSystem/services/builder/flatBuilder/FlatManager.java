package com.AccountingSystem.services.builder.flatBuilder;

public class FlatManager {
    public void getFlatWithTerrace(FlatBuilder builder, int numberOfFlat, double squareOfTerrace){
        builder.setNumberOfFlat(numberOfFlat);
        builder.setTerrace(squareOfTerrace);
    }
    public void getFlatWithSwimmingPool(FlatBuilder builder, int numberOfFlat, double maxDepth, double volume){
        builder.setNumberOfFlat(numberOfFlat);
        builder.setSwimmingPool(maxDepth, volume);
    }
    public void getFlatWithTerraceAndSwimmingPool(FlatBuilder builder, int numberOfFlat, double squareOfTerrace, double maxDepth, double volume){
        builder.setNumberOfFlat(numberOfFlat);
        builder.setTerrace(squareOfTerrace);
        builder.setSwimmingPool(maxDepth, volume);
    }
    public void getSimpleFlat(FlatBuilder builder, int numberOfFlat){
        builder.setNumberOfFlat(numberOfFlat);
    }
}