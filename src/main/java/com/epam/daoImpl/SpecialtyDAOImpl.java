package com.epam.daoImpl;

import com.epam.consoleView.Util;
import com.epam.dao.SpecialtyDAO;
import com.epam.model.Specialty;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SpecialtyDAOImpl extends Util implements SpecialtyDAO {

    private Connection connection;

    @Override
    public void create(Specialty specialty) {
        connection = connect();
        String sql = "INSERT INTO specialty (spec_id,spec_name,spec_description) values (?,?,?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, specialty.getSpecialtyId());
            preparedStatement.setString(2, specialty.getName());
            preparedStatement.setString(3, specialty.getDescription());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect(connection);
        }
    }

    @Override
    public List<Specialty> getAll() {
        connection = connect();
        String sql = "SELECT * FROM specialty";
        List<Specialty> specialtyList = new ArrayList<>();
        Statement statement;
        Specialty specialty;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                specialty = new Specialty();
                specialty.setSpecialtyId(resultSet.getInt("spec_id"));
                specialty.setName(resultSet.getString("spec_name"));
                specialty.setDescription(resultSet.getString("spec_description"));
                specialtyList.add(specialty);
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect(connection);
        }
        return specialtyList;
    }

    @Override
    public Specialty getById(int specialtyId) {
        connection = connect();
        String sql = "SELECT * FROM specialty WHERE spec_id=?";
        PreparedStatement preparedStatement;
        Specialty specialty = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, specialtyId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                specialty = new Specialty();
                specialty.setSpecialtyId(resultSet.getInt("spec_id"));
                specialty.setName(resultSet.getString("spec_name"));
                specialty.setDescription(resultSet.getString("spec_description"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect(connection);
        }
        return specialty;
    }

    @Override
    public void update(Specialty specialty) {
        connection = connect();
        String sql = "UPDATE specialty SET spec_name=?, spec_description=? WHERE spec_id=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, specialty.getName());
            preparedStatement.setString(2, specialty.getDescription());
            preparedStatement.setInt(3, specialty.getSpecialtyId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect(connection);
        }
    }

    @Override
    public void remove(Specialty specialty) {
        connection = connect();
        String sql = "DELETE FROM specialty WHERE spec_id=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, specialty.getSpecialtyId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect(connection);
        }
    }

    @Override
    public void deleteAndReplaceStudentsToAnother(int newSpecialtyId, int oldSpecialtyId) {
        connection = connect();
        String updateSql = "UPDATE gradebook SET spec_id=? WHERE spec_id=?";
        String deleteSql = "DELETE FROM specialty WHERE spec_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateSql);
            preparedStatement.setInt(1, newSpecialtyId);
            preparedStatement.setInt(2, oldSpecialtyId);
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement(deleteSql);
            preparedStatement.setInt(1, oldSpecialtyId);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect(connection);
        }
    }
}
