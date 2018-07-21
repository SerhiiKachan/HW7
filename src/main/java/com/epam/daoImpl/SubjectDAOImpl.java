package com.epam.daoImpl;

import com.epam.consoleView.Util;
import com.epam.dao.SubjectDAO;
import com.epam.model.Subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SubjectDAOImpl extends Util implements SubjectDAO {

    private Connection connection;

    @Override
    public void create(Subject subject) {
        connection = connect();
        String sql = "INSERT INTO subject (sub_id,sub_name,sub_description) values (?,?,?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, subject.getSubjectId());
            preparedStatement.setString(2, subject.getName());
            preparedStatement.setString(3, subject.getDescription());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect(connection);
        }
    }

    @Override
    public List<Subject> getAll() {
        connection = connect();
        String sql = "SELECT * FROM subject";
        List<Subject> subjectList = new ArrayList<>();
        Statement statement;
        Subject subject;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                subject = new Subject();
                subject.setSubjectId(resultSet.getInt("sub_id"));
                subject.setName(resultSet.getString("sub_name"));
                subject.setDescription(resultSet.getString("sub_description"));
                subjectList.add(subject);
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect(connection);
        }
        return subjectList;
    }

    @Override
    public Subject getById(int subjectId) {
        connection = connect();
        String sql = "SELECT * FROM subject WHERE sub_id=?";
        PreparedStatement preparedStatement;
        Subject subject = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, subjectId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                subject = new Subject();
                subject.setSubjectId(resultSet.getInt("sub_id"));
                subject.setName(resultSet.getString("sub_name"));
                subject.setDescription(resultSet.getString("sub_description"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect(connection);
        }
        return subject;
    }

    @Override
    public void update(Subject subject) {
        connection = connect();
        String sql = "UPDATE subject SET sub_name=?, sub_description=? WHERE sub_id=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, subject.getName());
            preparedStatement.setString(2, subject.getDescription());
            preparedStatement.setInt(3, subject.getSubjectId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect(connection);
        }
    }

    @Override
    public void remove(Subject subject) {
        connection = connect();
        String sql = "DELETE FROM subject WHERE sub_id=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, subject.getSubjectId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect(connection);
        }
    }
}
