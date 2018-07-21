package com.epam.daoImpl;

import com.epam.consoleView.Util;
import com.epam.dao.ExamDAO;
import com.epam.model.Exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ExamDAOImpl extends Util implements ExamDAO {

    private Connection connection;


    @Override
    public void create(Exam exam) {
        connection = connect();
        String sql = "INSERT INTO exam (exam_id,stud_id,sub_id,date_of_exam,stud_mark) values (?,?,?,?,?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, exam.getExamId());
            preparedStatement.setInt(2, exam.getStudentId());
            preparedStatement.setInt(3, exam.getSubjectId());
            preparedStatement.setDate(4, exam.getDateOfExam());
            preparedStatement.setInt(5, exam.getStudMark());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect(connection);
        }
    }

    @Override
    public List<Exam> getAll() {
        connection = connect();
        String sql = "SELECT * FROM exam";
        List<Exam> examList = new ArrayList<>();
        Statement statement;
        Exam exam;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                exam = new Exam();
                exam.setExamId(resultSet.getInt("exam_id"));
                exam.setStudentId(resultSet.getInt("stud_id"));
                exam.setSubjectId(resultSet.getInt("sub_id"));
                exam.setDateOfExam(resultSet.getDate("date_of_exam"));
                exam.setStudMark(resultSet.getInt("stud_mark"));
                examList.add(exam);
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect(connection);
        }
        return examList;
    }

    @Override
    public Exam getById(int examId) {
        connection = connect();
        String sql = "SELECT * FROM exam WHERE exam_id=?";
        PreparedStatement preparedStatement;
        Exam exam = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, examId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                exam = new Exam();
                exam.setExamId(resultSet.getInt("exam_id"));
                exam.setStudentId(resultSet.getInt("stud_id"));
                exam.setSubjectId(resultSet.getInt("sub_id"));
                exam.setDateOfExam(resultSet.getDate("date_of_exam"));
                exam.setStudMark(resultSet.getInt("stud_mark"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect(connection);
        }
        return exam;
    }

    @Override
    public void update(Exam exam) {
        connection = connect();
        String sql = "UPDATE exam SET stud_id=?, sub_id=?, date_of_exam=?, stud_mark=? WHERE exam_id=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, exam.getStudentId());
            preparedStatement.setInt(2, exam.getSubjectId());
            preparedStatement.setDate(3, exam.getDateOfExam());
            preparedStatement.setInt(4, exam.getStudMark());
            preparedStatement.setInt(5, exam.getExamId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect(connection);
        }
    }

    @Override
    public void remove(Exam exam) {
        connection = connect();
        String sql = "DELETE FROM exam WHERE exam_id=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, exam.getExamId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect(connection);
        }
    }
}
