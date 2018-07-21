package com.epam.daoImpl;

import com.epam.consoleView.Util;
import com.epam.dao.StudentDAO;
import com.epam.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl extends Util implements StudentDAO {

    private Connection connection;

    @Override
    public void create(Student student) {
        connection = connect();
        String sql = "INSERT INTO student (stud_id,stud_fname,stud_lname,stud_middle_name,stud_phone_number,pass_serial_number,gb_number) values (?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, student.getStudentId());
            preparedStatement.setString(2, student.getFirstName());
            preparedStatement.setString(3, student.getLastName());
            preparedStatement.setString(4, student.getMiddleName());
            preparedStatement.setString(5, student.getPhoneNumber());
            preparedStatement.setInt(6, student.getPassSerialNumber());
            preparedStatement.setInt(7, student.getGradebookNumber());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect(connection);
        }
    }

    @SuppressWarnings(value = "unchecked")
    @Override
    public List<Student> getAll() {
        connection = connect();
        String sql = "SELECT * FROM student";
        List<Student> studentList = new ArrayList<>();
        Statement statement;
        Student student;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                student = new Student();
                student.setStudentId(resultSet.getInt("stud_id"));
                student.setFirstName(resultSet.getString("stud_fname"));
                student.setLastName(resultSet.getString("stud_lname"));
                student.setMiddleName(resultSet.getString("stud_middle_name"));
                student.setPhoneNumber(resultSet.getString("stud_phone_number"));
                student.setPassSerialNumber(resultSet.getInt("pass_serial_number"));
                student.setGradebookNumber(resultSet.getInt("gb_number"));
                studentList.add(student);
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect(connection);
        }
        return studentList;
    }

    @Override
    public Student getById(int studentId) {
        connection = connect();
        String sql = "SELECT * FROM student WHERE stud_id=?";
        PreparedStatement preparedStatement;
        Student student = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, studentId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                student = new Student();
                student.setStudentId(resultSet.getInt("stud_id"));
                student.setFirstName(resultSet.getString("stud_fname"));
                student.setLastName(resultSet.getString("stud_lname"));
                student.setMiddleName(resultSet.getString("stud_middle_name"));
                student.setPhoneNumber(resultSet.getString("stud_phone_number"));
                student.setPassSerialNumber(resultSet.getInt("pass_serial_number"));
                student.setGradebookNumber(resultSet.getInt("gb_number"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect(connection);
        }
        return student;
    }

    @Override
    public void update(Student student) {
        connection = connect();
        String sql = "UPDATE student SET stud_fname=?, stud_lname=?, stud_middle_name=?, stud_phone_number=?, pass_serial_number=?, gb_number=? WHERE stud_id=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setString(3, student.getMiddleName());
            preparedStatement.setString(4, student.getPhoneNumber());
            preparedStatement.setInt(5, student.getPassSerialNumber());
            preparedStatement.setInt(6, student.getGradebookNumber());
            preparedStatement.setInt(7, student.getStudentId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect(connection);
        }
    }

    @Override
    public void remove(Student student) {
        connection = connect();
        String sql = "DELETE FROM student WHERE stud_id=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, student.getStudentId());
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement("DELETE FROM passport WHERE pass_serial_number=?");
            preparedStatement.setInt(1, student.getPassSerialNumber());
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement("DELETE FROM gradebook WHERE gb_number=?");
            preparedStatement.setInt(1, student.getGradebookNumber());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect(connection);
        }
    }
}


