package com.AccountingSystem.Test;

import com.AccountingSystem.house.House;
import com.AccountingSystem.services.HouseService;
import com.AccountingSystem.services.builder.flatBuilder.FlatBuilder;
import com.AccountingSystem.services.builder.houseBuilder.HouseBuilder;
import com.AccountingSystem.services.builder.houseBuilder.HouseManager;
import com.AccountingSystem.services.dao.DAOIn;
import com.AccountingSystem.services.dao.DbDataManager;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class DbDataManagerTest {


    @org.junit.jupiter.api.Test
    void getById() {
        House expected = HouseManager.getRandomHouse(HouseBuilder.getHouseBuilder(), FlatBuilder.getFlatBuilder(), 1, 2, 4, 100);
        DAOIn db = DbDataManager.getDbDataManager();
        int lastId = db.insert(expected);
        House actual = db.getById(lastId);
        assertEquals(expected, actual);
    }
}