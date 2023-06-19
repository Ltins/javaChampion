package org.ltins;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static final String USER_NAME = "root";
    public static final String URL = "jdbc:mysql://localhost:3306/oleg";

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            System.out.print("Input your password: ");
            String password = in.nextLine();
            in.close();

            Connection connection = DriverManager.getConnection(URL, USER_NAME, password);

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from providers");

            while (resultSet.next()){
                System.out.println(resultSet.getString("country_of_origin"));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        }
    }
}