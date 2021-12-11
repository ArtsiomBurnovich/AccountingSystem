package com.AccountingSystem;

import com.AccountingSystem.house.*;
import java.util.List;
import java.util.ArrayList;

public class AccountingSystem {
    private final List<House> houses = new ArrayList<House>();

    public void addHouse(House house){
        houses.add(house);
    }
    public House getHouse(int index){
        return houses.get(index);
    }
    public void removeHouse(int index){
        houses.remove(index);
    }
    public int getCountOfHouses(){
        return houses.size();
    }
}
