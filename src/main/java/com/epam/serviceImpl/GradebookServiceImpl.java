package com.epam.serviceImpl;

import com.epam.dao.GradebookDAO;
import com.epam.daoImpl.GradebookDAOImpl;
import com.epam.model.Gradebook;
import com.epam.service.GradebookService;

import java.util.List;

public class GradebookServiceImpl implements GradebookService {

    private GradebookDAO gradebookDAO = new GradebookDAOImpl();

    @Override
    public void createGradebook(Gradebook gradebook) {
        gradebookDAO.create(gradebook);
    }

    @Override
    public List<Gradebook> getAllGradebooks() {
        return gradebookDAO.getAll();
    }

    @Override
    public Gradebook getGradebookByGBNumber(int gbNumber) {
        return gradebookDAO.getByGBNumber(gbNumber);
    }

    @Override
    public void updateGradebook(Gradebook gradebook) {
        gradebookDAO.update(gradebook);
    }

    @Override
    public void removeGradebook(Gradebook gradebook) {
        gradebookDAO.remove(gradebook);
    }
}
