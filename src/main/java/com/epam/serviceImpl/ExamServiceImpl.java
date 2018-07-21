package com.epam.serviceImpl;

import com.epam.dao.ExamDAO;
import com.epam.daoImpl.ExamDAOImpl;
import com.epam.model.Exam;
import com.epam.service.ExamService;

import java.util.List;

public class ExamServiceImpl implements ExamService {

    private ExamDAO examDAO = new ExamDAOImpl();

    @Override
    public void createExam(Exam exam) {
        examDAO.create(exam);
    }

    @Override
    public List<Exam> getAllExams() {
        return examDAO.getAll();
    }

    @Override
    public Exam getExamById(int examId) {
        return examDAO.getById(examId);
    }

    @Override
    public void updateExam(Exam exam) {
        examDAO.update(exam);
    }

    @Override
    public void removeExam(Exam exam) {
        examDAO.remove(exam);
    }
}
