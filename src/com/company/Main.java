package com.company;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        ArrayList<House> Houses = new ArrayList<>();
        int count_of_houses = 0;

        System.out.println("Welcome to Accounting system!\n Use command [help] to show all available commands");
        String command;
        while (true) {
            command = in.nextLine();
            command = command.toLowerCase();
            command = command.replaceAll(" ", "");
            //System.out.println(command);

            //Build house with parking: [build house with parking] or [build with parking] or [build w p]
            if (command.contains("buildhousewithparking") || command.contains("buildwithparking") || command.contains("buildwp")){
                Houses.add(HouseFactory.getHouse((EnumHouses.PARKING)));
                System.out.println("The " + Houses.get(count_of_houses).name + " " + (count_of_houses + 1) + " was build!");
                count_of_houses++;
                continue;
            }

            //Build house with helicopter place: [build house with helicopter place] or [build with helicopter] or [build w h]
            if (command.contains("buildhousewithhelicopterplace") || command.contains("buildwithhelicopter") || command.contains("buildwh")){
                Houses.add(HouseFactory.getHouse((EnumHouses.HELICOPTER)));
                System.out.println("The " + Houses.get(count_of_houses).name + " " + (count_of_houses + 1) + " was build!");
                count_of_houses++;
                continue;
            }

            //Build house with elevator: [build house with elevator] or [build with elevator] or [build w e]
            if (command.contains("buildhousewithelevator") || command.contains("buildwithelevator") || command.contains("buildwe")){
                Houses.add(HouseFactory.getHouse((EnumHouses.ELEVATOR)));
                System.out.println("The " + Houses.get(count_of_houses).name + " " + (count_of_houses + 1) + " was build!");
                count_of_houses++;
                continue;
            }

            //To show all houses use: [show all houses] or [show all]
            if (command.contains("showallhouses") || command.contains("showall")) {
                if (count_of_houses == 0) {
                    System.out.println("Count of houses == 0! You should build new house!");
                    continue;
                } else {
                    for (int i = 0; i < count_of_houses; i++) {
                        Houses.get(i).printHouse();
                    }
                }
                continue;
            }

            //To show one house use: [show house [index]] or [show [index]]
            if (command.contains("showhouse") || command.contains("show")){
                command = command.replaceAll("[^0-9]", "");
                if (command.isEmpty()){
                    System.out.println("Wrong command! Must be: show [number of house]");
                }
                else {
                    int index = Integer.parseInt(command);
                    if (index > count_of_houses || index < 1) {
                        System.out.println("Wrong index!");
                        continue;
                    }
                    Houses.get(index - 1).printHouse();
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
                    if (index > count_of_houses || index < 0){
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
                    if (index > count_of_houses || index < 0) {
                        System.out.println("Wrong index!");
                        continue;
                    }
                    while (true) {
                        short ask;
                        System.out.println("\n################################################################");
                        System.out.println(Houses.get(index-1).name + index + " control panel:");
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
                                Houses.get(index - 1).printHouse();
                                break;
                            case 2:
                                Houses.get(index - 1).addFloor();
                                System.out.println("Floor on house " + (index) + " was added!");
                                break;
                            case 3:
                                while (true) {
                                    System.out.println("In what floor you want to add new flat? (1 - " + Houses.get(index - 1).getCountOfFloors() + ")");
                                    int temp_floor;
                                    temp_floor = in.nextInt();
                                    if (temp_floor <= 0 || temp_floor > Houses.get(index - 1).getCountOfFloors()) {
                                        System.out.println("Wrong number of floor! Count of floors in this house are " + Houses.get(index - 1).getCountOfFloors() + ". Try again!");
                                    } else {
                                        int new_count_of_humans;
                                        int new_count_of_rooms;
                                        double new_square;
                                        int new_price;

                                        System.out.println("Count of humans: ");
                                        new_count_of_humans = in.nextInt();
                                        System.out.println("Count of rooms: ");
                                        new_count_of_rooms = in.nextInt();
                                        System.out.println("Square: ");
                                        new_square = in.nextDouble();
                                        System.out.println("Price: ");
                                        new_price = in.nextInt();
                                        Houses.get(index - 1).atFloor(temp_floor - 1).addFlat(new_count_of_humans, new_count_of_rooms, new_square, new_price);

                                        System.out.println("New flat added. Current count of flats:" + Houses.get(index - 1).getCountOfFlats());
                                        break;
                                    }
                                }
                                break;
                            case 4:
                                System.out.println("Count of Humans in House: " + Houses.get(index - 1).getCountOfHumans());
                                break;
                            case 5:
                                System.out.println("Whole square of House: " + Houses.get(index - 1).getSquare());
                                break;
                            case 6:
                                boolean flag = true;
                                while (flag) {
                                    if (Houses.get(index - 1).getCountOfFloors() == 0) {
                                        System.out.println("There 0 floors in House" + index + "!");
                                        break;
                                    }
                                    System.out.println("In what floor you want to create? (1 - " + Houses.get(index - 1).getCountOfFloors() + ")");
                                    int temp_floor;
                                    temp_floor = in.nextInt();
                                    if (temp_floor < 1 || temp_floor > Houses.get(index - 1).getCountOfFloors()) {
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
                                        System.out.println("Floor " + temp_floor + " control panel");
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
                                                Houses.get(index - 1).atFloor(temp_floor - 1).printFloor();
                                            }
                                            case 2 -> {
                                                int new_count_of_humans;
                                                int new_count_of_rooms;
                                                double new_square;
                                                int new_price;
                                                System.out.println("Count of humans: ");
                                                new_count_of_humans = in.nextInt();
                                                System.out.println("Count of rooms: ");
                                                new_count_of_rooms = in.nextInt();
                                                System.out.println("Square: ");
                                                new_square = in.nextDouble();
                                                System.out.println("Price: ");
                                                new_price = in.nextInt();
                                                Houses.get(index - 1).atFloor(temp_floor - 1).addFlat(new_count_of_humans, new_count_of_rooms, new_square, new_price);
                                                System.out.println("New flat added. Current count of flats:" + Houses.get(index - 1).getCountOfFlats());
                                            }
                                            case 3 -> System.out.println(Houses.get(index - 1).atFloor(temp_floor - 1).getCountOfHumansOnFloor());
                                            case 4 -> {
                                                Houses.get(index - 1).atFloor(temp_floor - 1).getSquareOfFloor();
                                                System.out.println(Houses.get(index - 1).atFloor(temp_floor - 1).getSquareOfFloor());
                                            }
                                            case 5 -> {
                                                boolean flag_1 = true;
                                                while (flag_1) {
                                                    short temp_flat;
                                                    System.out.println("Choose the flat on the floor (1 - " + Houses.get(index - 1).atFloor(temp_floor - 1).getCountOfFlatsOnFloor() + ")");
                                                    temp_flat = in.nextShort();
                                                    if (temp_flat < 1 || temp_flat > Houses.get(index - 1).atFloor(temp_floor - 1).getCountOfFlatsOnFloor()) {
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
                                                                Houses.get(index - 1).atFloor(temp_floor - 1).atFlat(temp_flat - 1).setCountOfHumans(new_count_of_humans_2);
                                                            }
                                                            case 2 -> {
                                                                int new_count_of_rooms_2;
                                                                System.out.println("Count of rooms: ");
                                                                new_count_of_rooms_2 = in.nextInt();
                                                                Houses.get(index - 1).atFloor(temp_floor - 1).atFlat(temp_flat - 1).setCountOfRooms(new_count_of_rooms_2);
                                                            }
                                                            case 3 -> {
                                                                double new_square_2;
                                                                System.out.println("Square: ");
                                                                new_square_2 = in.nextDouble();
                                                                Houses.get(index - 1).atFloor(temp_floor - 1).atFlat(temp_flat - 1).setSquare(new_square_2);
                                                            }
                                                            case 4 -> {
                                                                int new_price_2;
                                                                System.out.println("Price: ");
                                                                new_price_2 = in.nextInt();
                                                                Houses.get(index - 1).atFloor(temp_floor - 1).atFlat(temp_flat - 1).setPrice(new_price_2);
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

            if(command.contains("help"))
            {
                System.out.println("""
                        
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
        }
    }
}







 

