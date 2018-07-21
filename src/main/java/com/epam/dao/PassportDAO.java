package com.epam.dao;

import com.epam.model.Passport;

import java.util.List;

public interface PassportDAO {

    void create(Passport passport);

    List<Passport> getAll();

    Passport getBySerialNumber(int serialNumber);

    void update(Passport passport);

    void remove(Passport passport);

}
