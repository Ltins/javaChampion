package DataBase;

import java.sql.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class DBConnection {
    public Connection connection;
    public DBConnection(final String userName, final String password, final String URLIndex){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + URLIndex, userName, password);
        }catch(SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        }
    }
    public void printTable(String tableName){
        ResultSet table;
        Statement statement;
        try {
            statement = connection.createStatement();
            table = statement.executeQuery("select * from " + tableName);

            ResultSetMetaData metaData = table.getMetaData();
            int columnCount = metaData.getColumnCount();

            System.out.println("Table name: " + metaData.getTableName(1));
            for (int i = 1; i<= columnCount; i++) {
                System.out.format("%21s", metaData.getColumnName(i) + "|");
            }
            System.out.println("\nTable data:");
            while (table.next()){
                for(int i = 1; i<= columnCount; i++) {
                    System.out.format("%21s", table.getString(i) + "|");
                }
            }
            System.out.println(" ");
            table.close();
            statement.close();
        }catch(SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        }
    }
    public void printTableInfo(String tableName){
        ResultSet table;
        Statement statement;
        try {
            statement = connection.createStatement();
            table = statement.executeQuery("select * from " + tableName);

            ResultSetMetaData metaData = table.getMetaData();
            int columnCount = metaData.getColumnCount();

            System.out.println("Table name: " + metaData.getTableName(1));
            System.out.format("%21s", "Field" + "|");
            for (int i = 1; i<= columnCount; i++){
                System.out.format("%21s", metaData.getColumnName(i) + "|");
            }
            System.out.println(" ");
            System.out.format("%21s", "Type" + "|");
            for (int i = 1; i<= columnCount; i++) {
                System.out.format("%21s", metaData.getColumnTypeName(i) + "|");
            }
            System.out.println(" ");
            System.out.format("%21s", "Precision" + "|");
            for (int i = 1; i<= columnCount; i++) {
                System.out.format("%21s", metaData.getPrecision(i) + "|");
            }
            System.out.println(" ");
            table.close();
            statement.close();
        }catch(SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        }
    }
    public void printTables()
    {
        ResultSet tables;
        Statement statement;
        try {
            statement = connection.createStatement();
            tables = statement.executeQuery("SHOW TABLES");

            System.out.println("Tables in the current database: ");
            int i = 1;
            while(tables.next()) {
                System.out.print("[" + i + "]" + " " + tables.getString(1));
                i++;
                System.out.println();
            }

            tables.close();
            statement.close();
        }catch(SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        }
    }

}