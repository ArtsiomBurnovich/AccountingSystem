package com.AccountingSystem.services.dao;

import com.AccountingSystem.house.House;

import java.sql.*;

public class HouseSaver extends DbConfigs{
    public static int saveHouse(House house){
        int houseID = 0;
        int numberOfHouse = house.getNumberOfHouse();
        int countOfFloors = house.getCountOfFloors();
        double elevatorSpeed = house.getElevator().getElevatorSpeed();
        int maxElevatorLoad = house.getElevator().getMaxLoad();
        int maxCountOfCars = house.getParking().getMaxCountOfCars();
        try {
            Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            String sqlStr = "INSERT INTO House (numberOfHouse, countOfFloors, elevatorSpeed, maxElevatorLoad, maxCountOfCars) " +
                            "Values (" + numberOfHouse + ", " + countOfFloors + ", " + elevatorSpeed + ", " + maxElevatorLoad + ", " + maxCountOfCars + ");";
            PreparedStatement housePreparedStatement = connection.prepareStatement(sqlStr, PreparedStatement.RETURN_GENERATED_KEYS);
            int rows = housePreparedStatement.executeUpdate();
            ResultSet houseResultSet = housePreparedStatement.getGeneratedKeys();
            while(houseResultSet.next()){
                houseID = houseResultSet.getInt(1);
            }
            connection.close();
            housePreparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  houseID;
    }
}
