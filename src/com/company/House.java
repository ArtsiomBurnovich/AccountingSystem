package com.company;
import java.util.ArrayList;

public class House {
    private int count_of_floors;
    private int count_of_flats;
    private int number_of_house;
    private  ArrayList<Floor> floors = new ArrayList<>();

    public class Floor {
        private int number_of_floor;
        private ArrayList<Flat> flats_on_floor = new ArrayList<>();

        public class Flat {
            private int count_of_humans;
            private int count_of_rooms;
            private double square;
            private int price;
            private int number_of_flat;

            Flat(int new_number_of_flat) {
                count_of_humans = 0;
                count_of_rooms = 0;
                square = 0;
                price = 0;
                number_of_flat = new_number_of_flat;
            }

            Flat(int new_count_of_humans, int new_count_of_rooms, double new_square, int new_price, int new_number_of_flat) {
                count_of_humans = new_count_of_humans;
                count_of_rooms = new_count_of_rooms;
                square = new_square;
                price = new_price;
                number_of_flat = new_number_of_flat;
            }

            public int Get_count_of_humans() {
                return count_of_humans;
            }

            public int Get_count_of_rooms() {
                return count_of_rooms;
            }

            public double Get_square() {
                return square;
            }

            public int Get_price() {
                return price;
            }

            public int Get_number_of_flat() {
                return number_of_flat;
            }

            public void Set_count_of_humans(int new_count_of_humans) {
                count_of_humans = new_count_of_humans;
            }

            public void Set_count_of_rooms(int new_count_of_rooms) {
                count_of_rooms = new_count_of_rooms;
            }

            public void Set_square(double new_square) {
                square = new_square;
            }

            public void Set_price(int new_price) {
                price = new_price;
            }

            public void Print_Flat() {
                System.out.println("          Number of flat: " + number_of_flat +
                        "\n          Count of humans: " + count_of_humans +
                        "\n          Count of rooms: " + count_of_rooms +
                        "\n          Square: " + square +
                        "\n          Price: " + price);
            }
        }

        Floor(int new_number_of_floor) {
            number_of_floor = new_number_of_floor;
        }

        public void Add_flat(int new_count_of_humans, int new_count_of_rooms, double new_square, int new_price) {
            count_of_flats++;
            flats_on_floor.add(new Flat(new_count_of_humans, new_count_of_rooms, new_square, new_price, count_of_flats));
        }

        public void Add_flat() {
            count_of_flats++;
            flats_on_floor.add(new Flat(count_of_flats));

        }

        public int Get_count_of_flats_on_floor() {
            return flats_on_floor.size();
        }

        public int Get_number_of_floor() {
            return number_of_floor;
        }

        public int[] Get_numbers_of_flats_on_floor() {
            int size = flats_on_floor.size();
            int[] Array = new int[size];
            for (int i = 0; i < size; i++) {
                Array[i] = flats_on_floor.get(i).Get_number_of_flat();
            }
            return Array;
        }

        public int Get_Count_Of_Humans_On_Floor() {
            int sum = 0;
            for (int i = 0; i < Get_count_of_flats_on_floor(); i++) {
                sum += flats_on_floor.get(i).count_of_humans;
            }
            return sum;
        }

        public int Get_Square_Of_Floor() {
            int sum = 0;
            for (int i = 0; i < Get_count_of_flats_on_floor(); i++) {
                sum += flats_on_floor.get(i).square;
            }
            return sum;
        }

        public Flat atFlat(int index) {
            return flats_on_floor.get(index);
        }

        public void printFloor(){
            int count_of_flats_on_the_floor  = flats_on_floor.size();
            for (Flat flat : flats_on_floor) {
                flat.Print_Flat();
                System.out.println("\n");
            }
        }
    }

    House(int new_number_of_house) {
        count_of_floors = 0;
        count_of_flats = 0;
        number_of_house = new_number_of_house;
    }

    public void Add_floor() {
        count_of_floors++;
        floors.add(new Floor(count_of_floors));
    }

    public int Get_count_of_flats() {
        return count_of_flats;
    }

    public int Get_count_of_floors() {
        return count_of_floors;
    }

    public int Get_number_of_house() {
        return number_of_house;
    }

    public void Set_number_of_house(int new_number) {
        number_of_house = new_number;
    }

    public int Get_Count_Of_Humans() {
        int sum = 0;
        for (int i = 0; i < count_of_floors; i++) {
            sum += floors.get(i).Get_Count_Of_Humans_On_Floor();
        }
        return sum;
    }

    public int Get_Square() {
        int sum = 0;
        for (int i = 0; i < count_of_floors; i++) {
            sum += floors.get(i).Get_Square_Of_Floor();
        }
        return sum;
    }

    public Floor atFloor(int index) {
        return floors.get(index);
    }

    public void printHouse() {
        System.out.println("The House " + this.Get_number_of_house() + ":\n");
        int count_of_floors = this.Get_count_of_floors();
        for (int i = 0; i < count_of_floors; i++) {
            System.out.println("     Floor " + (i + 1) + " :\n");
            int count_of_flats_on_the_floor = this.floors.get(i).Get_count_of_flats_on_floor();
            for (int j = 0; j < count_of_flats_on_the_floor; j++) {
                this.atFloor(i).flats_on_floor.get(j).Print_Flat();
                System.out.println("\n");
            }
        }
    }
}



