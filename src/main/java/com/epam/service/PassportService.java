package com.epam.service;

import com.epam.model.Passport;

import java.util.List;

public interface PassportService {

    void createPassport(Passport passport);

    List<Passport> getAllPassports();

    Passport getPassportBySerialNumber(int serialNumber);

    void updatePassport(Passport passport);

    void removePassport(Passport passport);

}
