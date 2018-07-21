package com.epam.daoImpl;

import com.epam.consoleView.Util;
import com.epam.dao.PassportDAO;
import com.epam.model.Passport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PassportDAOImpl extends Util implements PassportDAO {

    private Connection connection;

    @Override
    public void create(Passport passport) {
        connection = connect();
        String sql = "INSERT INTO passport (pass_serial_number,gender,date_of_birth,father_or_mother_full_name,address) values (?,?,?,?,?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, passport.getSerialNumber());
            preparedStatement.setString(2, passport.getGender());
            preparedStatement.setDate(3, passport.getDateOfBirth());
            preparedStatement.setString(4, passport.getFatherOrMotherFullName());
            preparedStatement.setString(5, passport.getAddress());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect(connection);
        }
    }

    @Override
    public List<Passport> getAll() {
        connection = connect();
        String sql = "SELECT * FROM passport";
        List<Passport> passportList = new ArrayList<>();
        Statement statement;
        Passport passport;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                passport = new Passport();
                passport.setSerialNumber(resultSet.getInt("pass_serial_number"));
                passport.setGender(resultSet.getString("gender"));
                passport.setDateOfBirth(resultSet.getDate("date_of_birth"));
                passport.setFatherOrMotherFullName(resultSet.getString("father_or_mother_full_name"));
                passport.setAddress(resultSet.getString("address"));
                passportList.add(passport);
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect(connection);
        }
        return passportList;
    }

    @Override
    public Passport getBySerialNumber(int serialNumber) {
        connection = connect();
        String sql = "SELECT * FROM passport WHERE pass_serial_number=?";
        PreparedStatement preparedStatement;
        Passport passport = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, serialNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                passport = new Passport();
                passport.setSerialNumber(resultSet.getInt("pass_serial_number"));
                passport.setGender(resultSet.getString("gender"));
                passport.setDateOfBirth(resultSet.getDate("date_of_birth"));
                passport.setFatherOrMotherFullName(resultSet.getString("father_or_mother_full_name"));
                passport.setAddress(resultSet.getString("address"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect(connection);
        }
        return passport;
    }

    @Override
    public void update(Passport passport) {
        connection = connect();
        String sql = "UPDATE passport SET gender=?, date_of_birth=?, father_or_mother_full_name=?, address=? WHERE pass_serial_number=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, passport.getSerialNumber());
            preparedStatement.setString(2, passport.getGender());
            preparedStatement.setDate(3, passport.getDateOfBirth());
            preparedStatement.setString(4, passport.getFatherOrMotherFullName());
            preparedStatement.setString(5, passport.getAddress());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect(connection);
        }
    }

    @Override
    public void remove(Passport passport) {
        connection = connect();
        String sql = "DELETE FROM passport WHERE pass_serial_number=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, passport.getSerialNumber());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect(connection);
        }
    }
}
