package com.epam.service;

import com.epam.model.Gradebook;

import java.util.List;

public interface GradebookService {

    void createGradebook(Gradebook gradebook);

    List<Gradebook> getAllGradebooks();

    Gradebook getGradebookByGBNumber(int gbNumber);

    void updateGradebook(Gradebook gradebook);

    void removeGradebook(Gradebook gradebook);

}
