package com.epam.dao;

import com.epam.model.Gradebook;

import java.util.List;

public interface GradebookDAO {

    void create(Gradebook gradebook);

    List<Gradebook> getAll();

    Gradebook getByGBNumber(int gbNumber);

    void update(Gradebook gradebook);

    void remove(Gradebook gradebook);

}
