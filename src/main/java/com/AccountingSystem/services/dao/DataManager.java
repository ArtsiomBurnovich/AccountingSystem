package com.AccountingSystem.services.dao;

import com.AccountingSystem.house.Flat;
import com.AccountingSystem.house.Floor;
import com.AccountingSystem.house.House;

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

}
