package com.epam.dao;

import com.epam.model.Exam;

import java.util.List;

public interface ExamDAO {

    void create(Exam exam);

    List<Exam> getAll();

    Exam getById(int examId);

    void update(Exam exam);

    void remove(Exam exam);

}
