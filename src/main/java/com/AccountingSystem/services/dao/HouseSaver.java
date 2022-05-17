package com.AccountingSystem.services.dao;
import com.AccountingSystem.house.Floor;
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

    public static House readHouseFromDb (int houseId){
        House tempHouse = new House();
        String houseSqlStr = "SELECT * FROM House WHERE idHouse = " + houseId + ";";
        try {
            Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(houseSqlStr);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                tempHouse.setNumberOfHouse(resultSet.getInt(2));
                tempHouse.setElevator(resultSet.getDouble(4), resultSet.getInt(5));
                tempHouse.setParking(resultSet.getInt(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tempHouse;
    }


}
