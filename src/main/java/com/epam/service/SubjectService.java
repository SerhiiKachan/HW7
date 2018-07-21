package com.epam.service;

import com.epam.model.Subject;

import java.util.List;

public interface SubjectService {

    void createSubject(Subject subject);

    List<Subject> getAllSubjects();

    Subject getSubjectById(int subjectId);

    void updateSubject(Subject subject);

    void removeSubject(Subject subject);

}
