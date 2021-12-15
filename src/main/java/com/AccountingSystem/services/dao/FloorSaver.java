package com.AccountingSystem.services.dao;

import com.AccountingSystem.house.Flat;
import com.AccountingSystem.house.Floor;

import javax.print.attribute.HashDocAttributeSet;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    public static HashMap<Integer, Floor> readFloorFromDb (int houseId){
        HashMap <Integer, Floor> floors = new HashMap<>();
        Floor tempFloor = new Floor();
        String floorSqlStr = "SELECT * FROM Floor WHERE houseID = " + houseId + ";";
        try {
            Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(floorSqlStr);
            ResultSet resultSet = preparedStatement.executeQuery();
            Integer tempFloorId;
            while (resultSet.next()){
                tempFloorId = resultSet.getInt(1);
                tempFloor.setNumberOfFloor(resultSet.getInt(3));
                floors.put(tempFloorId, tempFloor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return floors;
    }

}

