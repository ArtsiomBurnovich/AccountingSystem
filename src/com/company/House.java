package com.company;
import java.util.ArrayList;

public class House {
    private int count_of_floors;
    private int count_of_flats;
    private int number_of_house;
    public String name;
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

            public int getCountOfHumans() {
                return count_of_humans;
            }

            public int getCountOfRooms() {
                return count_of_rooms;
            }

            public double getSquare() {
                return square;
            }

            public int getPrice() {
                return price;
            }

            public int getNumberOfFlat() {
                return number_of_flat;
            }

            public void setCountOfHumans(int new_count_of_humans) {
                count_of_humans = new_count_of_humans;
            }

            public void setCountOfRooms(int new_count_of_rooms) {
                count_of_rooms = new_count_of_rooms;
            }

            public void setSquare(double new_square) {
                square = new_square;
            }

            public void setPrice(int new_price) {
                price = new_price;
            }

            public void printFlat() {
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

        public void addFlat(int new_count_of_humans, int new_count_of_rooms, double new_square, int new_price) {
            count_of_flats++;
            flats_on_floor.add(new Flat(new_count_of_humans, new_count_of_rooms, new_square, new_price, count_of_flats));
        }

        public void addFlat() {
            count_of_flats++;
            flats_on_floor.add(new Flat(count_of_flats));
        }

        public int getCountOfFlatsOnFloor() {
            return flats_on_floor.size();
        }

        public int getNumberOfFloor() {
            return number_of_floor;
        }

        public int[] getNumbersOfFlatsOnFloor() {
            int size = flats_on_floor.size();
            int[] Array = new int[size];
            for (int i = 0; i < size; i++) {
                Array[i] = flats_on_floor.get(i).getNumberOfFlat();
            }
            return Array;
        }

        public int getCountOfHumansOnFloor() {
            int sum = 0;
            for (int i = 0; i < getCountOfFlatsOnFloor(); i++) {
                sum += flats_on_floor.get(i).count_of_humans;
            }
            return sum;
        }

        public int getSquareOfFloor() {
            int sum = 0;
            for (int i = 0; i < getCountOfFlatsOnFloor(); i++) {
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
                flat.printFlat();
                System.out.println("\n");
            }
        }
    }

    House(){
        count_of_floors = 0;
        count_of_flats = 0;
    }
    House(int new_number_of_house) {
        count_of_floors = 0;
        count_of_flats = 0;
        number_of_house = new_number_of_house;
    }

    public void addFloor() {
        count_of_floors++;
        floors.add(new Floor(count_of_floors));
    }

    public int getCountOfFlats() {
        return count_of_flats;
    }

    public int getCountOfFloors() {
        return count_of_floors;
    }

    public int getNumberOfHouse() {
        return number_of_house;
    }

    public void setNumberOfHouse(int new_number) {
        number_of_house = new_number;
    }

    public int getCountOfHumans() {
        int sum = 0;
        for (int i = 0; i < count_of_floors; i++) {
            sum += floors.get(i).getCountOfHumansOnFloor();
        }
        return sum;
    }

    public int getSquare() {
        int sum = 0;
        for (int i = 0; i < count_of_floors; i++) {
            sum += floors.get(i).getSquareOfFloor();
        }
        return sum;
    }

    public Floor atFloor(int index) {
        return floors.get(index);
    }

    public void printHouse() {
        System.out.println("The " + name + " " + this.getNumberOfHouse() + ":\n");
        int count_of_floors = this.getCountOfFloors();
        for (int i = 0; i < count_of_floors; i++) {
            System.out.println("     Floor " + (i + 1) + " :\n");
            int count_of_flats_on_the_floor = this.floors.get(i).getCountOfFlatsOnFloor();
            for (int j = 0; j < count_of_flats_on_the_floor; j++) {
                this.atFloor(i).flats_on_floor.get(j).printFlat();
                //System.out.println("\n");
            }
        }
    }
}



