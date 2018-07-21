package com.epam.service;

import com.epam.model.Exam;

import java.util.List;

public interface ExamService {

    void createExam(Exam exam);

    List<Exam> getAllExams();

    Exam getExamById(int examId);

    void updateExam(Exam exam);

    void removeExam(Exam exam);

}
