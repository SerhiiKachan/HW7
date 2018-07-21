package com.epam.consoleView;

import com.epam.constant.SQLCommands;
import org.apache.log4j.Logger;

import java.sql.*;

public class Util {

    private static final Logger LOG = Logger.getLogger(Util.class);
    private static final String URL = "jdbc:mysql://localhost:3306/university?user=ENTER&password=ENTER&useUnicode=true&characterEncoding=UTF-8";
    private static final String USER = "ENTER";
    private static final String PASSWORD = "ENTER";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    private Connection firstConnect() {
        Connection connection = null;
        String url = "jdbc:mysql://localhost:3306/?user=ENTER&password=ENTER&useUnicode=true&characterEncoding=UTF-8";
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(url, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
    protected Connection connect() {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    protected void disconnect(Connection connection) {
        try {
            if (connection != null)
                connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void createAndFillDatabase() {
        Connection connection = firstConnect();
        String createDatabase = "CREATE DATABASE IF NOT EXISTS university";
        String using = "USE university";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(createDatabase);
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement(using);
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement(SQLCommands.TABLE_EXAM);
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement(SQLCommands.TABLE_GRADEBOOK);
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement(SQLCommands.TABLE_PASSPORT);
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement(SQLCommands.TABLE_SPECIALTY);
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement(SQLCommands.TABLE_STUDENT);
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement(SQLCommands.TABLE_SUBJECT);
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement(SQLCommands.EXAM_CONSTRAINTS);
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement(SQLCommands.GRADEBOOK_CONSTRAINTS);
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement(SQLCommands.STUDENT_CONSTRAINTS);
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement(SQLCommands.PASSPORT_INSERT);
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement(SQLCommands.SPECIALTY_INSERT);
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement(SQLCommands.SUBJECT_INSERT);
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement(SQLCommands.GRADEBOOK_INSERT);
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement(SQLCommands.STUDENT_INSERT);
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement(SQLCommands.EXAM_INSERT);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            try {
                preparedStatement = connection.prepareStatement("DROP DATABASE university");
                preparedStatement.executeUpdate();
                createAndFillDatabase();
            }catch (Exception e1){
                e1.printStackTrace();
            }
        } finally {
            disconnect(connection);
        }
    }

    void getAllMetaData() {
        Connection connection = connect();
        try {
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            ResultSet tableNames = databaseMetaData.getTables(null, null, null, new String[]{"Table"});
            System.out.println("All tables:");
            while (tableNames.next())
                System.out.print(tableNames.getString("TABLE_NAME") + "  ");
            tableNames.close();
            ResultSet tables = databaseMetaData.getTables(null, null, null, new String[]{"Table"});
            System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            while (tables.next()) {
                System.out.print("TABLE: ");
                System.out.println(tables.getString("TABLE_NAME"));

                ResultSet columns = databaseMetaData
                        .getColumns(null, null, tables.getString("TABLE_NAME"),
                                null);
                System.out.println("\ncolumns:");
                while (columns.next()) {
                    String name = columns.getString("COLUMN_NAME");
                    System.out.print(name + "  ");
                }
                ResultSet primaryKeys = databaseMetaData.getPrimaryKeys(null, null,
                        tables.getString("TABLE_NAME"));
                while (primaryKeys.next()) {
                    System.out.println("\n");
                    System.out.println(primaryKeys.getString("COLUMN_NAME") + " = " + primaryKeys.getString
                            ("PK_NAME"));
                }
                ResultSet foreignKeys = databaseMetaData.getImportedKeys(null, null,
                        tables.getString("TABLE_NAME"));
                System.out.println("foreign keys:");
                while (foreignKeys.next()) {
                    System.out.println(foreignKeys.getString("PKTABLE_NAME") + ":" +
                            foreignKeys.getString("PKCOLUMN_NAME") + " = " + foreignKeys.getString("FKTABLE_NAME")
                            + ":"
                            + foreignKeys.getString("FKCOLUMN_NAME"));
                }
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            }
            tables.close();
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            LOG.error("Changes rolled back.");
        } finally {
            disconnect(connection);
        }
    }
}

