package com.AccountingSystem.services.dao;

import com.AccountingSystem.house.House;

public interface DAOIn{

    //return Id of inserted class
    int insert(House o);

    House getById(int Id);
}
