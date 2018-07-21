package com.epam.dao;

import com.epam.model.Subject;

import java.util.List;

public interface SubjectDAO {

    void create(Subject subject);

    List<Subject> getAll();

    Subject getById(int subjectId);

    void update(Subject subject);

    void remove(Subject subject);

}
