package com.AccountingSystem.house.facilities.flatFacilities;

public class SwimmingPool {
    private double maxDepth;
    private double volume;

    public SwimmingPool(){
        this.maxDepth = 0;
        this.volume = 0;
    }
    public SwimmingPool(double maxDepth, double volume){
        this.volume = volume;
        this.maxDepth = maxDepth;
    }

    public void setMaxDepth(double maxDepth){
        this.maxDepth = maxDepth;
    }
    public void setVolume (double volume){
        this.volume = volume;
    }

    public double getMaxDepth() {
        return maxDepth;
    }
    public double getVolume() {
        return volume;
    }
}

