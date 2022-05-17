package com.AccountingSystem.test;

import com.AccountingSystem.house.House;
import com.AccountingSystem.services.builder.flatBuilder.FlatBuilder;
import com.AccountingSystem.services.builder.houseBuilder.HouseBuilder;
import com.AccountingSystem.services.builder.houseBuilder.HouseManager;
import com.AccountingSystem.services.dao.DAOIn;
import com.AccountingSystem.services.dao.DbDataManager;

import static org.junit.jupiter.api.Assertions.*;

class DbDataManagerTest {


    @org.junit.jupiter.api.Test
    void getById() {
        House expected = HouseManager.getRandomHouse(1, 2, 4, 100);
        DAOIn db = DbDataManager.getDbDataManager();
        int lastId = db.insert(expected);
        House actual = db.getById(lastId);
        assertEquals(expected, actual);
    }
}