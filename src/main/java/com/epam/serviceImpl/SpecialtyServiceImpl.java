package com.epam.serviceImpl;

import com.epam.dao.SpecialtyDAO;
import com.epam.daoImpl.SpecialtyDAOImpl;
import com.epam.model.Specialty;
import com.epam.service.SpecialtyService;

import java.util.List;

public class SpecialtyServiceImpl implements SpecialtyService {

    private SpecialtyDAO specialtyDAO = new SpecialtyDAOImpl();

    @Override
    public void createSpecialty(Specialty specialty) {
        specialtyDAO.create(specialty);
    }

    @Override
    public List<Specialty> getAllSpecialties() {
        return specialtyDAO.getAll();
    }

    @Override
    public Specialty getSpecialtyById(int specialtyId) {
        return specialtyDAO.getById(specialtyId);
    }

    @Override
    public void updateSpecialty(Specialty specialty) {
        specialtyDAO.update(specialty);
    }

    @Override
    public void removeSpecialty(Specialty specialty) {
        specialtyDAO.remove(specialty);
    }

    @Override
    public void deleteSpecialtyAndReplaceStudentsToAnotherSpecialty(int newSpecialtyId, int oldSpecialtyId) {
        specialtyDAO.deleteAndReplaceStudentsToAnother(newSpecialtyId, oldSpecialtyId);
    }
}
