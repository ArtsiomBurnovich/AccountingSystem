package com.AccountingSystem.services.dao;

import com.AccountingSystem.house.Flat;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public static List<Flat> readFlatFromDb (int floorId){
        List<Flat> flats =  new ArrayList<>();
        Flat tempFlat = new Flat();
        String flatSqlStr = "SELECT * FROM Flat WHERE floorID = " + floorId + ";";
        try {
            Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(flatSqlStr);
            ResultSet resultSet = preparedStatement.executeQuery();
            int counter = 0;
            while (resultSet.next()){
                flats.add(new Flat());
                flats.get(counter).setNumberOfFlat(resultSet.getInt(3));
                flats.get(counter).setCountOfHumans((resultSet.getInt(4)));
                flats.get(counter).setCountOfRooms(resultSet.getInt(5));
                flats.get(counter).setSquare(resultSet.getDouble(6));
                flats.get(counter).setPrice(resultSet.getInt(7));
                flats.get(counter).setSwimmingPool(resultSet.getDouble(8), resultSet.getDouble(9));
                flats.get(counter).setTerrace(resultSet.getDouble(10));
                counter++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flats;
    }
}
