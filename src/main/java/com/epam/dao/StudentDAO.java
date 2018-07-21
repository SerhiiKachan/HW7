package com.epam.dao;

import com.epam.model.Student;

import java.util.List;

public interface StudentDAO {

    void create(Student student);

    List<Student> getAll();

    Student getById(int studentId);

    void update(Student student);

    void remove(Student student);

}
