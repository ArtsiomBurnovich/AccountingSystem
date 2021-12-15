package com.AccountingSystem;
import com.AccountingSystem.house.Flat;
import com.AccountingSystem.house.Floor;
import com.AccountingSystem.house.House;
import com.AccountingSystem.services.FlatService;
import com.AccountingSystem.services.FloorService;
import com.AccountingSystem.services.HouseService;
import com.AccountingSystem.services.builder.flatBuilder.FlatBuilder;
import com.AccountingSystem.services.builder.houseBuilder.HouseBuilder;
import com.AccountingSystem.services.builder.houseBuilder.HouseManager;
import com.AccountingSystem.services.dao.DataManager;
import com.AccountingSystem.services.dao.FlatSaver;
import com.AccountingSystem.services.dao.FloorSaver;
import com.AccountingSystem.services.dao.HouseSaver;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        /*House h = HouseManager.getRandomHouse(HouseBuilder.getHouseBuilder(), FlatBuilder.getFlatBuilder(), 666, 3, 6, 1000);
        DataManager.writeToDb(h);*/
        House tempHouse = DataManager.readFromDb(114);
        HouseService.printHouse(tempHouse);
       /* List<Flat> flats = FlatSaver.readFlatFromDb(60);
        FlatService.printFlat(flats.get(0));
        FlatService.printFlat(flats.get(1));*/
    }
}



