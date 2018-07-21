package com.epam.dao;

import com.epam.model.Specialty;

import java.util.List;

public interface SpecialtyDAO {

    void create(Specialty specialty);

    List<Specialty> getAll();

    Specialty getById(int specialtyId);

    void update(Specialty specialty);

    void remove(Specialty specialty);

    void deleteAndReplaceStudentsToAnother(int newSpecialtyId, int oldSpecialtyId);

}
