package com.company;
import java.awt.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        House house = new House(17);
        System.out.println("The 'House 17' without floors and flats was built...");
        short ask = 0;
        short ask_1;
        short ask_2;

        while(ask == 0){
            while (true) {
                System.out.println(
                                "1) Show whole House\n" +
                                "2) Add Floor\n" +
                                "3) Add Flat\n" +
                                "4) Show full count of humans\n" +
                                "5) Full square of House\n" +
                                "6) Floor control panel\n" +
                                "7) Flat control panel\n");

                ask_1 = in.nextShort();
                if (ask_1 <= 0 || ask_1 > 7){
                    System.out.println("There is no such number. You should write 1-7");
                    continue;
                }
                else break;
            }
            switch (ask_1){
                case 1:
                    System.out.println("The House " + house.Get_number_of_house() + ":\n");
                    int count_of_floors = house.Get_count_of_floors();
                    for (int i = 0; i < count_of_floors; i++){
                        System.out.println("     Floor " + (i+1) + " :\n");
                        int count_of_flats_on_the_floor = house.floors.get(i).Get_count_of_flats_on_floor();
                        for (int j = 0; j < count_of_flats_on_the_floor; j++){
                            house.floors.get(i).flats_on_floor.get(j).Print_Flat();
                            System.out.println("\n");
                        }
                    }
                    break;
                case 2:
                    house.Add_floor();
                    System.out.println("Floor added! The full count of floors: " + house.Get_count_of_floors());
                    break;
                case 3:
                    int temp_floor;
                    boolean flag = true;

                    while (true) {
                        if (house.Get_count_of_floors() == 0){
                            short zero_floors;
                            System.out.println("There are 0 floors! Can we create a new floor and add flat after them?(0) - yes; 1) - no)");
                            zero_floors = in.nextShort();
                            if (zero_floors == 0){
                              house.Add_floor();
                              System.out.println("Floor added! The full count of floors: " + house.Get_count_of_floors());
                            }
                            else{
                                
                            }
                        }
                        System.out.println("In what floor you want to place a new flat? (Count of floors: " + house.Get_count_of_floors() + ")\n");
                        temp_floor = in.nextInt();
                        if (temp_floor > house.Get_count_of_floors() || temp_floor <= 0) {
                            System.out.println("Wrong number of floor! Try again!");
                            continue;
                        }
                        else break;
                    }

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
                    house.floors.get(temp_floor-1).Add_flat(new_count_of_humans,  new_count_of_rooms, new_square, new_price);

                    System.out.println("New flat added. Current count of flats:" + house.Get_count_of_flats());
                    break;
                case 4:
                    System.out.println("Count of Humans in House: " + house.Get_Count_Of_Humans());
                    break;
                case 5:
                    System.out.println("Whole square of House: " + house.Get_Square());
            }
            System.out.println("Continue? 0) - yes; 1) - no\n");
            ask = in.nextShort();
        }
    }
}

