package com.epam.serviceImpl;

import com.epam.dao.PassportDAO;
import com.epam.daoImpl.PassportDAOImpl;
import com.epam.model.Passport;
import com.epam.service.PassportService;

import java.util.List;

public class PassportServiceImpl implements PassportService {

    private PassportDAO passportDAO = new PassportDAOImpl();

    @Override
    public void createPassport(Passport passport) {
        passportDAO.create(passport);
    }

    @Override
    public List<Passport> getAllPassports() {
        return passportDAO.getAll();
    }

    @Override
    public Passport getPassportBySerialNumber(int serialNumber) {
        return passportDAO.getBySerialNumber(serialNumber);
    }

    @Override
    public void updatePassport(Passport passport) {
        passportDAO.update(passport);
    }

    @Override
    public void removePassport(Passport passport) {
        passportDAO.remove(passport);
    }
}
