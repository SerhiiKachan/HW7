package com.epam.daoImpl;

import com.epam.consoleView.Util;
import com.epam.dao.GradebookDAO;
import com.epam.model.Gradebook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GradebookDAOImpl extends Util implements GradebookDAO {

    private Connection connection;

    @Override
    public void create(Gradebook gradebook) {
        connection = connect();
        String sql = "INSERT INTO gradebook (gb_number,date_of_admission,st_group,course,form_of_education,spec_id) values (?,?,?,?,?,?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, gradebook.getGbNumber());
            preparedStatement.setDate(2, gradebook.getDateOfAdmission());
            preparedStatement.setString(3, gradebook.getStudGroup());
            preparedStatement.setInt(4, gradebook.getCourse());
            preparedStatement.setString(5, gradebook.getFormOfEducation());
            preparedStatement.setInt(6, gradebook.getSpecialtyId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect(connection);
        }
    }

    @Override
    public List<Gradebook> getAll() {
        connection = connect();
        String sql = "SELECT * FROM gradebook";
        List<Gradebook> gradebookList = new ArrayList<>();
        Statement statement;
        Gradebook gradebook;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                gradebook = new Gradebook();
                gradebook.setGbNumber(resultSet.getInt("gb_number"));
                gradebook.setDateOfAdmission(resultSet.getDate("date_of_admission"));
                gradebook.setStudGroup(resultSet.getString("st_group"));
                gradebook.setCourse(resultSet.getInt("course"));
                gradebook.setFormOfEducation(resultSet.getString("form_of_education"));
                gradebook.setSpecialtyId(resultSet.getInt("spec_id"));
                gradebookList.add(gradebook);
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect(connection);
        }
        return gradebookList;
    }

    @Override
    public Gradebook getByGBNumber(int gbNumber) {
        connection = connect();
        String sql = "SELECT * FROM gradebook WHERE gb_number=?";
        PreparedStatement preparedStatement;
        Gradebook gradebook = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, gbNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                gradebook = new Gradebook();
                gradebook.setGbNumber(resultSet.getInt("gb_number"));
                gradebook.setDateOfAdmission(resultSet.getDate("date_of_admission"));
                gradebook.setStudGroup(resultSet.getString("st_group"));
                gradebook.setCourse(resultSet.getInt("course"));
                gradebook.setFormOfEducation(resultSet.getString("form_of_education"));
                gradebook.setSpecialtyId(resultSet.getInt("spec_id"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect(connection);
        }
        return gradebook;
    }

    @Override
    public void update(Gradebook gradebook) {
        connection = connect();
        String sql = "UPDATE gradebook SET date_of_admission=?, st_group=?, course=?, form_of_education=?, spec_id=? WHERE gb_number=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDate(1, gradebook.getDateOfAdmission());
            preparedStatement.setString(2, gradebook.getStudGroup());
            preparedStatement.setInt(3, gradebook.getCourse());
            preparedStatement.setString(4, gradebook.getFormOfEducation());
            preparedStatement.setInt(5, gradebook.getSpecialtyId());
            preparedStatement.setInt(6, gradebook.getGbNumber());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect(connection);
        }
    }

    @Override
    public void remove(Gradebook gradebook) {
        connection = connect();
        PreparedStatement preparedStatement;
        String sql = "DELETE FROM gradebook WHERE gb_number=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, gradebook.getGbNumber());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect(connection);
        }
    }
}
