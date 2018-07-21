package com.epam.serviceImpl;

import com.epam.dao.StudentDAO;
import com.epam.daoImpl.StudentDAOImpl;
import com.epam.model.Student;
import com.epam.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentDAO studentDAO = new StudentDAOImpl();

    @Override
    public void createStudent(Student student) {
        studentDAO.create(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDAO.getAll();
    }

    @Override
    public Student getStudentById(int studentId) {
        return studentDAO.getById(studentId);
    }

    @Override
    public void updateStudent(Student student) {
        studentDAO.update(student);
    }

    @Override
    public void removeStudent(Student student) {
        studentDAO.remove(student);
    }
}
