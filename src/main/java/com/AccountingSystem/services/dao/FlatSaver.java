package com.AccountingSystem.services.dao;

import com.AccountingSystem.house.Flat;

import java.sql.*;

public class FlatSaver extends DbConfigs{
    public static void saveFlat(Flat flat, int floorId){
        int numberOfFlat = flat.getNumberOfFlat();
        int countOfHumans = flat.getCountOfHumans();
        int countOfRooms = flat.getCountOfRooms();
        double square = flat.getSquare();
        double price = flat.getPrice();
        double maxDepthOfSwimPool = flat.getSwimmingPool().getMaxDepth();
        double valueOfSwimPool = flat.getSwimmingPool().getVolume();
        double terraceSquare = flat.getTerrace().getTerraceSquare();
        try {
            Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            String sqlStr = "INSERT INTO Flat (floorID, numberOfFlat, countOfHumans, countOfRooms, suare, price, maxDepthOfSwimPool, volumeOfSwimPool, terraceSquare) " +
                            "Values (" + floorId + ", " + numberOfFlat + ", " + countOfHumans + ", " +countOfRooms + ", " +square + ", " +price + ", " +maxDepthOfSwimPool + ", " +valueOfSwimPool + ", " +terraceSquare + ");";
            PreparedStatement flatPreparedStatement = connection.prepareStatement(sqlStr);
            flatPreparedStatement.executeUpdate();
            connection.close();
            flatPreparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
