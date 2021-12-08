package com.AccountingSystem;
import com.AccountingSystem.house.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        ArrayList<House> Houses = new ArrayList<>();
        int countOfHouses = 0;

        System.out.println("Welcome to Accounting system!\n Use command [help] to show all available commands");
        String command;
        while (true) {
            command = in.nextLine();
            command = command.toLowerCase();
            command = command.replaceAll(" ", "");
            //System.out.println(command);

            switch (command) {
                //Build com.AccountingSystem.house with parking: [build com.AccountingSystem.house with parking] or [build with parking] or [build w p]
                case "buildwp" -> {
                    Houses.add(HouseFactory.getHouse((HousesTypes.PARKING)));
                    Houses.get(countOfHouses).setNumberOfHouse(countOfHouses + 1);
                    System.out.println("The " + Houses.get(countOfHouses).getName() + " [" + (countOfHouses + 1) + "] was build!");
                    countOfHouses++;
                }

                //Build com.AccountingSystem.house with helicopter place: [build com.AccountingSystem.house with helicopter place] or [build with helicopter] or [build w h]
                case "buildwh" -> {
                    Houses.add(HouseFactory.getHouse((HousesTypes.HELICOPTER)));
                    Houses.get(countOfHouses).setNumberOfHouse(countOfHouses + 1);
                    System.out.println("The " + Houses.get(countOfHouses).getName() + " [" + (countOfHouses + 1) + "] was build!");
                    countOfHouses++;
                }

                //Build com.AccountingSystem.house with elevator: [build com.AccountingSystem.house with elevator] or [build with elevator] or [build w e]
                case "buildwe" -> {
                    Houses.add(HouseFactory.getHouse((HousesTypes.ELEVATOR)));
                    Houses.get(countOfHouses).setNumberOfHouse(countOfHouses + 1);
                    System.out.println("The " + Houses.get(countOfHouses).getName() + " [" + (countOfHouses + 1) + "] was build!");
                    countOfHouses++;
                }
                case "help" -> System.out.println("""
                                                
                        Build house with parking: [build house with parking] or [build with parking] or [build w p]
                                                
                        Build house with helicopter place: [build house with helicopter place] or [build with helicopter] or [build w h]
                                                
                        Build house with elevator: [build house with elevator] or [build with elevator] or [build w e]
                                                
                        To show all houses use: [show all houses] or [show all]
                                                
                        To show one house use: [show house [index]] or [show [index]]
                                                
                        To add one more floor to house use: [add floor [index]]
                                                
                        To open control panel of one house use: [control panel [index]] or [control [index]] or [c p [index]]
                                                
                        To end the program use: [exit]
                                                
                        """);
            }

            //To show all houses use: [show all houses] or [show all]
            if (command.contains("showall")){
                if (countOfHouses == 0) {
                    System.out.println("Count of houses == 0! You should build new house!");
                    break;
                } else {
                    for (int i = 0; i < countOfHouses; i++) {
                       System.out.println("The " + Houses.get(i).getName() + " " + (i+1));
                       for (int f = 0; f < Houses.get(i).getCountOfFloors(); f++){
                           System.out.println("  Floor " + (f+1) + " :");
                           for (int flat = 0; flat < Houses.get(i).getFloor(f).getCountOfFlatsOnFloor(); flat++){
                               System.out.println("     Flat " + (flat+1));
                               System.out.println("Count of humans: " + Houses.get(i).getFloor(f).getFlat(flat).getCountOfHumans());
                               System.out.println("Count of rooms: " + Houses.get(i).getFloor(f).getFlat(flat).getCountOfRooms());
                               System.out.println("Square: " + Houses.get(i).getFloor(f).getFlat(flat).getSquare());
                               System.out.println("Price: " + Houses.get(i).getFloor(f).getFlat(flat).getPrice());
                           }
                       }
                    }
                }
            }
            else{
                //To show one house use: [show com.AccountingSystem.house [index]] or [show [index]]
                if (command.contains("showhouse") || command.contains("show")){
                    command = command.replaceAll("[^0-9]", "");
                    if (command.isEmpty()){
                        System.out.println("Wrong command! Must be: show [number of house]");
                    }
                    else {
                        int index = Integer.parseInt(command);
                        if (index > countOfHouses || index < 1) {
                            System.out.println("Wrong index!");
                            continue;
                        }
                        for (int f = 0; f < Houses.get(index - 1).getCountOfFloors(); f++){
                            System.out.println("  Floor " + (f+1));
                            for (int flat = 0; flat < Houses.get(index - 1).getFloor(f).getCountOfFlatsOnFloor(); flat++){
                                System.out.println("     Flat " + (flat+1));
                                System.out.println("Count of humans: " + Houses.get(index - 1).getFloor(f).getFlat(flat).getCountOfHumans());
                                System.out.println("Count of rooms: " + Houses.get(index - 1).getFloor(f).getFlat(flat).getCountOfRooms());
                                System.out.println("Square: " + Houses.get(index - 1).getFloor(f).getFlat(flat).getSquare());
                                System.out.println("Price: " + Houses.get(index - 1).getFloor(f).getFlat(flat).getPrice());
                            }
                        }
                    }
                }
            }
            //To add one more floor to house use: [add floor [index]]
            if (command.contains("addfloor")){
                command = command.replaceAll("[^0-9]", "");
                if (command.isEmpty()){
                    System.out.println("Wrong command! Must be: add floor [number of house]");
                }
                else{
                    int index = Integer.parseInt(command);
                    if (index > countOfHouses || index < 0){
                        System.out.println("Wrong number of house!");
                        continue;
                    }
                    Houses.get(index-1).addFloor();
                    System.out.println("Floor on house " + (index) + " was added!");
                }
            }

            //To open control panel of one house use: [control panel [index]] or [control [index]] or [c p [index]]
            if (command.contains("controlpanel") || command.contains("control") || command.contains("cp")){
                command = command.replaceAll("[^0-9]", "");
                if (command.isEmpty()){
                    System.out.println("Wrong command! Must be: control panel  [number of house]");
                }
                else {
                    int index = Integer.parseInt(command);
                    if (index > countOfHouses || index < 0) {
                        System.out.println("Wrong index!");
                        continue;
                    }
                    while (true) {
                        short ask;
                        System.out.println("################################################################");
                        System.out.println(Houses.get(index-1).getName() + " " + index + " control panel:");
                        System.out.println("""
                                1) Show whole House
                                2) Add Floor
                                3) Add Flat
                                4) Show full count of humans
                                5) Full square of House
                                6) Floor control panel
                                7) Exit
                                """);
                        while (true) {
                            try {
                                in = new Scanner(System.in);
                                ask = in.nextShort();
                                break;
                            } catch (Exception c) {
                                System.out.println("It is not a number! Try again!");
                            }
                        }
                        if (ask <= 0 || ask > 7) {
                            System.out.println("Wrong number! Try again!");
                            continue;
                        }
                        if (ask == 7) {
                            System.out.println("################################################################");
                            break;
                        }
                        switch (ask) {
                            case 1:
                                for (int f = 0; f < Houses.get(index - 1).getCountOfFloors(); f++){
                                    System.out.println("  Floor " + (f+1) + " :");
                                    for (int flat = 0; flat < Houses.get(index - 1).getFloor(f).getCountOfFlatsOnFloor(); flat++){
                                        System.out.println("     Flat " + (flat+1));
                                        System.out.println("Count of humans: " + Houses.get(index - 1).getFloor(f).getFlat(flat).getCountOfHumans());
                                        System.out.println("Count of rooms: " + Houses.get(index - 1).getFloor(f).getFlat(flat).getCountOfRooms());
                                        System.out.println("Square: " + Houses.get(index - 1).getFloor(f).getFlat(flat).getSquare());
                                        System.out.println("Price: " + Houses.get(index - 1).getFloor(f).getFlat(flat).getPrice());
                                    }
                                }
                                break;
                            case 2:
                                Houses.get(index - 1).addFloor();
                                System.out.println("Floor on house " + (index) + " was added!");
                                break;
                            case 3:
                                while (true) {
                                    System.out.println("In what floor you want to add new flat? (1 - " + Houses.get(index - 1).getCountOfFloors() + ")");
                                    int tempFloor;
                                    tempFloor = in.nextInt();
                                    if (tempFloor <= 0 || tempFloor > Houses.get(index - 1).getCountOfFloors()) {
                                        if (tempFloor > Houses.get(index-1).getCountOfFloors()){
                                            System.out.println("You number out of border! You should add more floors!");
                                            break;
                                        }
                                        System.out.println("Wrong number of floor! Count of floors in this house are " + Houses.get(index - 1).getCountOfFloors() + ". Try again!");
                                    } else {
                                        int newCountOfHumans;
                                        int newCountOfRooms;
                                        double newSquare;
                                        int newPrice;
                                        System.out.println("Count of humans: ");
                                        newCountOfHumans = in.nextInt();
                                        System.out.println("Count of rooms: ");
                                        newCountOfRooms = in.nextInt();
                                        System.out.println("Square: ");
                                        newSquare = in.nextDouble();
                                        System.out.println("Price: ");
                                        newPrice = in.nextInt();
                                        Houses.get(index - 1).getFloor(tempFloor - 1).addFlat(newCountOfHumans, newCountOfRooms, newSquare, newPrice, Houses.get(index-1).getCountOfFlats());
                                        Houses.get(index-1).setCountOfFlats(Houses.get(index-1).getCountOfFlats()+1);
                                        System.out.println("New flat added. Current count of flats:" + Houses.get(index - 1).getCountOfFlats());
                                        break;
                                    }
                                }
                                break;
                            case 4:
                                int tempCountOfHumans = 0;
                                for (int h = 0; h < countOfHouses; h++){
                                    for (int floor = 0; floor < Houses.get(h).getCountOfFloors(); floor++) {
                                        for (int flat = 0; flat < Houses.get(h).getFloor(floor).getCountOfFlatsOnFloor(); flat++) {
                                            tempCountOfHumans += Houses.get(h).getFloor(floor).getFlat(flat).getCountOfHumans();
                                        }
                                    }
                                }
                                System.out.println("Count of Humans in House: " + tempCountOfHumans);
                                break;
                            case 5:
                                int tempSquare = 0;
                                for (int h = 0; h < countOfHouses; h++){
                                    for (int floor = 0; floor < Houses.get(h).getCountOfFloors(); floor++) {
                                        for (int flat = 0; flat < Houses.get(h).getFloor(floor).getCountOfFlatsOnFloor(); flat++) {
                                            tempSquare += Houses.get(h).getFloor(floor).getFlat(flat).getSquare();
                                        }
                                    }
                                }
                                System.out.println("Count of Humans in House: " + tempSquare);
                                break;
                            case 6:
                                boolean flag = true;
                                while (flag) {
                                    if (Houses.get(index - 1).getCountOfFloors() == 0) {
                                        System.out.println("There 0 floors in House" + index + "!");
                                        break;
                                    }
                                    System.out.println("In what floor you want to create? (1 - " + Houses.get(index - 1).getCountOfFloors() + ")");
                                    int tempFloor;
                                    tempFloor = in.nextInt();
                                    if (tempFloor < 1 || tempFloor > Houses.get(index - 1).getCountOfFloors()) {
                                        System.out.println("Wrong number of floor! Try again!");
                                        continue;
                                    }
                                    while (true) {
                                        short ask_1;
                                        while (true) {
                                            try {
                                                in = new Scanner(System.in);
                                                ask_1 = in.nextShort();
                                                break;
                                            } catch (Exception c) {
                                                System.out.println("It is not a number! Try again!");
                                            }
                                        }
                                        System.out.println("\n################################################################");
                                        System.out.println("Floor " + tempFloor + " control panel");
                                        System.out.println("""
                                                1) Show whole Floor
                                                2) Add Flat
                                                3) Show full count of humans
                                                4) Full square of House
                                                5) Flat control panel
                                                6) Exit
                                                """);
                                        ask_1 = in.nextShort();
                                        if (ask_1 < 1 || ask_1 > 6) {
                                            System.out.println("Wrong number! Try again!");
                                            continue;
                                        }
                                        if (ask_1 == 6) {
                                            System.out.println("################################################################");
                                            flag = false;
                                            break;
                                        }
                                        switch (ask_1) {
                                            case 1 -> {
                                                System.out.println("    Flats:\n");
                                                for (int flat = 0; flat < Houses.get(index - 1).getFloor(tempFloor-1).getCountOfFlatsOnFloor(); flat++){
                                                    System.out.println("     Flat " + (flat+1) + " \n");
                                                    System.out.println("Count of humans: " + Houses.get(index - 1).getFloor(tempFloor-1).getFlat(flat).getCountOfHumans());
                                                    System.out.println("Count of rooms: " + Houses.get(index - 1).getFloor(tempFloor-1).getFlat(flat).getCountOfRooms());
                                                    System.out.println("Square: " + Houses.get(index - 1).getFloor(tempFloor-1).getFlat(flat).getSquare());
                                                    System.out.println("Price: " + Houses.get(index - 1).getFloor(tempFloor-1).getFlat(flat).getPrice());
                                                }
                                            }
                                            case 2 -> {
                                                int newCountOfHumans;
                                                int newCountOfRooms;
                                                double newSquare;
                                                int newPrice;
                                                System.out.println("Count of humans: ");
                                                newCountOfHumans = in.nextInt();
                                                System.out.println("Count of rooms: ");
                                                newCountOfRooms = in.nextInt();
                                                System.out.println("Square: ");
                                                newSquare = in.nextDouble();
                                                System.out.println("Price: ");
                                                newPrice = in.nextInt();
                                                Houses.get(index - 1).getFloor(tempFloor - 1).addFlat(newCountOfHumans, newCountOfRooms, newSquare, newPrice, Houses.get(index-1).getCountOfFlats());
                                                Houses.get(index-1).setCountOfFlats(Houses.get(index-1).getCountOfFlats()+1);
                                                System.out.println("New flat added. Current count of flats:" + Houses.get(index - 1).getCountOfFlats());
                                                break;
                                            }
                                            case 3 ->{
                                                int tempCount = 0;
                                                for (int i = 0; i < Houses.get(index-1).getFloor(tempFloor-1).getCountOfFlatsOnFloor(); i++){
                                                    tempCount += Houses.get(index-1).getFloor(tempFloor-1).getFlat(i).getCountOfHumans();
                                                }
                                                System.out.println("Count of humans on the floor " + tempFloor + " is: " + tempCount);
                                            }
                                            case 4 -> {
                                                int tempFloorSquare = 0;
                                                for (int i = 0; i < Houses.get(index-1).getFloor(tempFloor-1).getCountOfFlatsOnFloor(); i++){
                                                    tempFloorSquare += Houses.get(index-1).getFloor(tempFloor-1).getFlat(i).getSquare();
                                                }
                                                System.out.println("Count of humans on the floor " + tempFloor + " is: " + tempFloorSquare);
                                            }
                                            case 5 -> {
                                                boolean flag_1 = true;
                                                while (flag_1) {
                                                    short temp_flat;
                                                    System.out.println("Choose the flat on the floor (1 - " + Houses.get(index - 1).getFloor(tempFloor - 1).getCountOfFlatsOnFloor() + ")");
                                                    temp_flat = in.nextShort();
                                                    if (temp_flat < 1 || temp_flat > Houses.get(index - 1).getFloor(tempFloor - 1).getCountOfFlatsOnFloor()) {
                                                        System.out.println("Wrong number of flat! Try again!");
                                                        continue;
                                                    }
                                                    while (true) {
                                                        short ask_2;
                                                        while (true) {
                                                            try {
                                                                in = new Scanner(System.in);
                                                                ask_2 = in.nextShort();
                                                                break;
                                                            } catch (Exception c) {
                                                                System.out.println("It is not a number! Try again!");
                                                            }
                                                        }
                                                        System.out.println("\n################################################################");
                                                        System.out.println("Flat " + temp_flat + " control panel");
                                                        System.out.println("""
                                                                1) Set count of humans
                                                                2) Set count of rooms
                                                                3) Set square
                                                                4) Set price
                                                                5) Exit
                                                                """);
                                                        ask_2 = in.nextShort();
                                                        if (ask_2 < 1 || ask_2 > 5) {
                                                            System.out.println("Wrong number! Try again!");
                                                            continue;
                                                        }
                                                        if (ask_2 == 5) {
                                                            System.out.println("################################################################");
                                                            flag_1 = false;
                                                            break;
                                                        }
                                                        switch (ask_2) {
                                                            case 1 -> {
                                                                int new_count_of_humans_2;
                                                                System.out.println("Count of humans: ");
                                                                new_count_of_humans_2 = in.nextInt();
                                                                Houses.get(index - 1).getFloor(tempFloor - 1).getFlat(temp_flat - 1).setCountOfHumans(new_count_of_humans_2);
                                                            }
                                                            case 2 -> {
                                                                int new_count_of_rooms_2;
                                                                System.out.println("Count of rooms: ");
                                                                new_count_of_rooms_2 = in.nextInt();
                                                                Houses.get(index - 1).getFloor(tempFloor - 1).getFlat(temp_flat - 1).setCountOfRooms(new_count_of_rooms_2);
                                                            }
                                                            case 3 -> {
                                                                double new_square_2;
                                                                System.out.println("Square: ");
                                                                new_square_2 = in.nextDouble();
                                                                Houses.get(index - 1).getFloor(tempFloor - 1).getFlat(temp_flat - 1).setSquare(new_square_2);
                                                            }
                                                            case 4 -> {
                                                                int new_price_2;
                                                                System.out.println("Price: ");
                                                                new_price_2 = in.nextInt();
                                                                Houses.get(index - 1).getFloor(tempFloor - 1).getFlat(temp_flat - 1).setPrice(new_price_2);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                        }
                    }
                }
            }

            //To end the program use: [exit]
            if (command.contains("exit")){
                break;
            }
        }
    }
}

 

