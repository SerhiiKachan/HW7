package com.epam.service;

import com.epam.model.Student;

import java.util.List;

public interface StudentService {

    void createStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(int studentId);

    void updateStudent(Student student);

    void removeStudent(Student student);

}
