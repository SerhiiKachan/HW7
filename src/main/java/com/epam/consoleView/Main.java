package com.epam.consoleView;

import com.epam.Task5.Mapper;
import com.epam.model.Student;

import java.sql.*;
import java.util.List;

public class Main {


    public static void main(String[] args){
        Util util = new Util();
        util.createAndFillDatabase();

        Menu menu = new Menu();
        menu.show();

        testMapper();
    }

    @SuppressWarnings(value = "unchecked")
     private static void testMapper(){
        Util util = new Util();
        Mapper mapper = new Mapper();
        Connection connection = util.connect();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM student");
            List<Student> list = mapper.executeMapping(resultSet, Student.class);
            list.forEach(System.out::println);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
