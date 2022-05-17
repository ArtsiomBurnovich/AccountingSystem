package com.AccountingSystem.services.dao;

import com.AccountingSystem.house.Flat;
import com.AccountingSystem.house.Floor;
import com.AccountingSystem.house.House;

import java.util.*;

public class DbDataManager extends DbConfigs implements DAOIn{

    //singleton
    public static DbDataManager dbDataManager;
    private DbDataManager() {
    }
    public static DbDataManager getDbDataManager() {
        if (dbDataManager == null) {
            dbDataManager = new DbDataManager();
        }
        return dbDataManager;
    }


    @Override
    public int insert(House o) {
        //return Id of inserted class
        int houseId = HouseSaver.saveHouse(o);
        int floorId;
        Flat tempFlat;
        Floor tempFloor;
        for (int i = 0; i < o.getCountOfFloors(); i++)
        {
            tempFloor = o.getFloor(i);
            floorId = FloorSaver.saveFloor(tempFloor, houseId);
            for (int j = 0; j < tempFloor.getCountOfFlatsOnFloor(); j++){
                tempFlat = tempFloor.getFlat(j);
                FlatSaver.saveFlat(tempFlat, floorId);
            }
        }
        return houseId;
    }

    @Override
    public House getById(int Id) {
        House tempHouse = new House();
        Floor tempFloor = new Floor();
        Flat tempFlat = new Flat();
        tempHouse = HouseSaver.readHouseFromDb(Id);
        HashMap<Integer, Floor> floors = FloorSaver.readFloorFromDb(Id);
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
