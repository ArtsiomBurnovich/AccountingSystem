package com.AccountingSystem;
import com.AccountingSystem.house.House;
import com.AccountingSystem.services.HouseService;
import com.AccountingSystem.services.builder.flatBuilder.FlatBuilder;
import com.AccountingSystem.services.builder.houseBuilder.HouseBuilder;
import com.AccountingSystem.services.builder.houseBuilder.HouseManager;
import com.AccountingSystem.services.dao.DataManager;

public class Main {

    public static void main(String[] args) {
        /*AccountingSystem acs = new AccountingSystem();
        acs.addHouse(HouseManager.getRandomHouse(HouseBuilder.getHouseBuilder(), FlatBuilder.getFlatBuilder(), 555, 2, 4, 100));
        House house = acs.getHouse(0);
        DataManager.saveAll(house);*/
        House h = HouseManager.getRandomHouse(HouseBuilder.getHouseBuilder(), FlatBuilder.getFlatBuilder(), 666, 3, 6, 1000);
        HouseService.printHouse(h);
        DataManager.writeToDb(h);
    }
}



