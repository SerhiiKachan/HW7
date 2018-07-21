package com.epam.service;

import com.epam.model.Specialty;

import java.util.List;

public interface SpecialtyService {

    void createSpecialty(Specialty specialty);

    List<Specialty> getAllSpecialties();

    Specialty getSpecialtyById(int specialtyId);

    void updateSpecialty(Specialty specialty);

    void removeSpecialty(Specialty specialty);

    void deleteSpecialtyAndReplaceStudentsToAnotherSpecialty(int newSpecialtyId, int oldSpecialtyId);

}
