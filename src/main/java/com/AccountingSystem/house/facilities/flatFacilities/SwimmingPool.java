package com.AccountingSystem.house.facilities.flatFacilities;

public class SwimmingPool {
    private double maxDepth;
    private double volume;

    SwimmingPool(){
        this.maxDepth = 0;
        this.volume = 0;
    }
    SwimmingPool(double maxDepth, double volume){
        this.volume = volume;
        this.maxDepth = maxDepth;
    }

    public void setMaxDepth(double maxDepth){
        this.maxDepth = maxDepth;
    }
    public void setVolume (double volume){
        this.volume = volume;
    }
}
