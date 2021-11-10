package Factory;
import Factory.HousesTypes;
import House.HouseWithParking;
import House.HouseWithElevator;
import House.HouseWithHelicopterPlace;
import House.House;

public class HouseFactory {

    public static House getHouse(HousesTypes type){
        House toReturn = null;
        switch (type){
            case PARKING -> {
                return new HouseWithParking();
            }
            case ELEVATOR -> {
                return new HouseWithElevator();
            }
            case HELICOPTER -> {
                return new HouseWithHelicopterPlace();
            }
            default -> {
                return null;
            }
        }
    }
}
