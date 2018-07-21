package com.epam.serviceImpl;

import com.epam.dao.SubjectDAO;
import com.epam.daoImpl.SubjectDAOImpl;
import com.epam.model.Subject;
import com.epam.service.SubjectService;

import java.util.List;

public class SubjectServiceImpl implements SubjectService {

    private SubjectDAO subjectDAO = new SubjectDAOImpl();

    @Override
    public void createSubject(Subject subject) {
        subjectDAO.create(subject);
    }

    @Override
    public List<Subject> getAllSubjects() {
        return subjectDAO.getAll();
    }

    @Override
    public Subject getSubjectById(int subjectId) {
        return subjectDAO.getById(subjectId);
    }

    @Override
    public void updateSubject(Subject subject) {
        subjectDAO.update(subject);
    }

    @Override
    public void removeSubject(Subject subject) {
        subjectDAO.remove(subject);
    }
}
