package com.AccountingSystem.services.dao;

import com.AccountingSystem.house.Flat;
import com.AccountingSystem.house.Floor;
import com.AccountingSystem.house.House;

import java.util.*;

public class DataManager extends DbConfigs{

    //singleton
    public static DataManager dataManager;
    private DataManager() {
    }
    public static DataManager getAllSaver() {
        if (dataManager == null) {
            dataManager = new DataManager();
        }
        return dataManager;
    }


    public static void writeToDb(House house){
        int houseId = HouseSaver.saveHouse(house);
        int floorId;
        Flat tempFlat;
        Floor tempFloor;
        for (int i = 0; i < house.getCountOfFloors(); i++)
        {
          tempFloor = house.getFloor(i);
          floorId = FloorSaver.saveFloor(tempFloor, houseId);
            for (int j = 0; j < tempFloor.getCountOfFlatsOnFloor(); j++){
                tempFlat = tempFloor.getFlat(j);
                FlatSaver.saveFlat(tempFlat, floorId);
            }
        }
    }

    public static House readFromDb(int houseId){
        House tempHouse = new House();
        Floor tempFloor = new Floor();
        Flat tempFlat = new Flat();
        HouseSaver.readHouseFromDb(houseId);
        HashMap<Integer, Floor> floors = FloorSaver.readFloorFromDb(houseId);
        List<Flat> flats = new ArrayList<>();
        int counter = 0;
        for (Map.Entry<Integer, Floor> entry : floors.entrySet()) {
            Integer key = entry.getKey();
            tempHouse.addFloor();
            flats = FlatSaver.readFlatFromDb((int)key);
            for (int i = 0; i < flats.size(); i++)
            {
                tempHouse.getFloor(counter).addFlat(flats.get(i));
            }
            counter++;
        }
        return tempHouse;
    }
}
