package com.AccountingSystem;
import com.AccountingSystem.house.Flat;
import com.AccountingSystem.house.House;
import com.AccountingSystem.services.FlatService;
import com.AccountingSystem.services.HouseService;
import com.AccountingSystem.services.builder.flatBuilder.FlatBuilder;
import com.AccountingSystem.services.builder.flatBuilder.FlatManager;
import com.AccountingSystem.services.builder.houseBuilder.HouseBuilder;
import com.AccountingSystem.services.builder.houseBuilder.HouseManager;

public class Main {

    public static void main(String[] args) {

        AccountingSystem acs = new AccountingSystem();
        HouseBuilder houseBuilder = new HouseBuilder();
        FlatBuilder flatBuilder = new FlatBuilder();

        acs.addHouse(HouseManager.getRandomHouse(houseBuilder, flatBuilder, 36, 24, 36, 100));
        House house =  acs.getHouse(0);
        HouseService.printHouse(house);
    }
}



