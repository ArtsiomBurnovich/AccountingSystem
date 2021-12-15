package com.AccountingSystem.services.dao;

import com.AccountingSystem.house.Floor;

import java.sql.*;

public class FloorSaver extends DbConfigs{
    public static int saveFloor(Floor floor, int houseId){
        int numberOfFloor = floor.getNumberOfFloor();
        int floorID = 0;
        try {
            Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            String sqlStr = "INSERT INTO Floor (houseID, numberOfFloor) " +
                            "Values (" + houseId + ", " + numberOfFloor + ");";
            PreparedStatement floorPreparedStatement = connection.prepareStatement(sqlStr, PreparedStatement.RETURN_GENERATED_KEYS);
            int rows = floorPreparedStatement.executeUpdate();
            ResultSet houseResultSet = floorPreparedStatement.getGeneratedKeys();
            while(houseResultSet.next()){
                floorID = houseResultSet.getInt(1);
            }
            connection.close();
            floorPreparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  floorID;
    }
}
