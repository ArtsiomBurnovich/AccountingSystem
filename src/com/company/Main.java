package com.company;
import java.awt.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        ArrayList<House> Houses = new ArrayList<>();
        int count_of_houses = 0;

        String command;
        while (true) {
            command = in.nextLine();
            command = command.toLowerCase();
            command = command.replaceAll(" ", "");
            //System.out.println(command);

            if (command.contains("buildhouse")) {
                Houses.add(new House(count_of_houses + 1));
                System.out.println("The House " + (count_of_houses + 1) + " without floors and flats was build!");
                count_of_houses++;
                continue;
            }

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

            if (command.contains("showhouse")){
                command = command.replaceAll("[^0-9]", "");
                int index = Integer.parseInt(command);
                if (index > count_of_houses || index < 0){
                    System.out.println("Wrong index!");
                    continue;
                }
                Houses.get(index -1).printHouse();
            }

            if (command.contains("addfloor")){
                command = command.replaceAll("[^0-9]", "");
                int index = Integer.parseInt(command);
                System.out.println("index: " + index);
                if (index > count_of_houses || index < 0){
                    System.out.println("Wrong index!");
                    continue;
                }
                Houses.get(index-1).Add_floor();
                System.out.println("Floor on house " + (index) + " was added!");
            }

            if (command.contains("controlpanel")){
                command = command.replaceAll("[^0-9]", "");
                int index = Integer.parseInt(command);
                if (index > count_of_houses || index < 0){
                    System.out.println("Wrong index!");
                    continue;
                }
                while (true){
                    short ask;
                    System.out.println("1) Show whole House\n" +
                            "2) Add Floor\n" +
                            "3) Add Flat\n" +
                            "4) Show full count of humans\n" +
                            "5) Full square of House\n" +
                            "6) Floor control panel\n" +
                            "7) Exit\n");

                    ask = in.nextShort();
                    if (ask <= 0 || ask > 7){
                        System.out.println("Wrong number! Try again!");
                        continue;
                    }
                    if (ask == 7){
                        break;
                    }
                    switch (ask) {
                        case 1:
                            Houses.get(index - 1).printHouse();
                            break;
                        case 2:
                            Houses.get(index - 1).Add_floor();
                            System.out.println("Floor on house " + (index) + " was added!");
                            break;
                        case 3:
                            while (true) {
                                System.out.println("In what floor you want to add new flat? (1 - " + Houses.get(index - 1).Get_count_of_floors() + ")");
                                int temp_floor;
                                temp_floor = in.nextInt();
                                if (temp_floor <= 0 || temp_floor > Houses.get(index - 1).Get_count_of_floors()) {
                                    System.out.println("Wrong number of floor! Count of floors in this house are " + Houses.get(index - 1).Get_count_of_floors() + ". Try again!");
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
                                    Houses.get(index - 1).atFloor(temp_floor - 1).Add_flat(new_count_of_humans, new_count_of_rooms, new_square, new_price);

                                    System.out.println("New flat added. Current count of flats:" + Houses.get(index - 1).Get_count_of_flats());
                                    break;
                                }
                            }
                            break;
                        case 4:
                            System.out.println("Count of Humans in House: " + Houses.get(index - 1).Get_Count_Of_Humans());
                            break;
                        case 5:
                            System.out.println("Whole square of House: " + Houses.get(index - 1).Get_Square());
                            break;
                        case 6:
                            boolean flag = true;
                            while (flag) {
                                System.out.println("In what floor you want to create? (1 - " + Houses.get(index - 1).Get_count_of_floors() + ")");
                                int temp_floor;
                                temp_floor = in.nextInt();
                                if (temp_floor < 1 || temp_floor > Houses.get(index - 1).Get_count_of_floors()) {
                                    System.out.println("Wrong number of floor! Try again!");
                                    continue;
                                }
                                while (true) {
                                    short ask_1;
                                    System.out.println("1) Show whole Floor\n" +
                                            "2) Add Flat\n" +
                                            "3) Show full count of humans\n" +
                                            "4) Full square of House\n" +
                                            "5) Flat control panel\n" +
                                            "6) Exit\n");
                                    ask_1 = in.nextShort();
                                    if (ask_1 < 1 || ask_1 > 6){
                                        System.out.println("Wrong number! Try again!");
                                        continue;
                                    }
                                    if (ask_1 == 6){
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
                                            Houses.get(index - 1).atFloor(temp_floor - 1).Add_flat(new_count_of_humans, new_count_of_rooms, new_square, new_price);
                                            System.out.println("New flat added. Current count of flats:" + Houses.get(index - 1).Get_count_of_flats());
                                        }
                                        case 3 -> {
                                            System.out.println(Houses.get(index - 1).atFloor(temp_floor - 1).Get_Count_Of_Humans_On_Floor());
                                        }
                                        case 4 -> {
                                            Houses.get(index - 1).atFloor(temp_floor - 1).Get_Square_Of_Floor();
                                            System.out.println(Houses.get(index - 1).atFloor(temp_floor - 1).Get_Square_Of_Floor());
                                        }
                                        case 5 -> {
                                            boolean flag_1 = true;
                                            while (flag_1) {
                                                short temp_flat;
                                                System.out.println("Choose the flat on the floor (1 - " + Houses.get(index - 1).atFloor(temp_floor - 1).Get_count_of_flats_on_floor());
                                                temp_flat = in.nextShort();
                                                if (temp_flat < 1 || temp_flat > Houses.get(index - 1).atFloor(temp_floor - 1).Get_count_of_flats_on_floor()) {
                                                    System.out.println("Wrong number of flat! Try again!");
                                                    continue;
                                                }
                                                while (true) {
                                                    short ask_2;
                                                    System.out.println("1) Set count of humans\n2) Set count of rooms\n3) Set square\n4) Set price\n5) Exit\n");
                                                    ask_2 = in.nextShort();
                                                    if (ask_2 < 1 || ask_2 > 5) {
                                                        System.out.println("Wrong number! Try again!");
                                                        continue;
                                                    }
                                                    if (ask_2 == 5) {
                                                        flag_1 = false;
                                                        break;
                                                    }
                                                    switch (ask_2) {
                                                        case 1 -> {
                                                            int new_count_of_humans_2;
                                                            System.out.println("Count of humans: ");
                                                            new_count_of_humans_2 = in.nextInt();
                                                            Houses.get(index - 1).atFloor(temp_floor - 1).atFlat(temp_flat - 1).Set_count_of_humans(new_count_of_humans_2);
                                                        }
                                                        case 2 -> {
                                                            int new_count_of_rooms_2;
                                                            System.out.println("Count of rooms: ");
                                                            new_count_of_rooms_2 = in.nextInt();
                                                            Houses.get(index - 1).atFloor(temp_floor - 1).atFlat(temp_flat - 1).Set_count_of_rooms(new_count_of_rooms_2);
                                                        }
                                                        case 3 -> {
                                                            double new_square_2;
                                                            System.out.println("Square: ");
                                                            new_square_2 = in.nextDouble();
                                                            Houses.get(index - 1).atFloor(temp_floor - 1).atFlat(temp_flat - 1).Set_square(new_square_2);
                                                        }
                                                        case 4 -> {
                                                            int new_price_2;
                                                            System.out.println("Price: ");
                                                            new_price_2 = in.nextInt();
                                                            Houses.get(index - 1).atFloor(temp_floor - 1).atFlat(temp_flat - 1).Set_price(new_price_2);
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

            if (command.contains("exit")){
                break;
            }
        }
    }
}







 

