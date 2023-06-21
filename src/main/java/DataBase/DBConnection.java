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
        try {
            Statement statement = connection.createStatement();
            ResultSet table = statement.executeQuery("select * from " + tableName);

            ResultSetMetaData metaData = table.getMetaData();
            int columnCount = metaData.getColumnCount();

            System.out.println("Table name: " + metaData.getTableName(1));
            for (int i = 1; i<= columnCount; i++) {
                System.out.format("%21s", "[" + i +"] " + metaData.getColumnName(i) + "|");
            }
            System.out.println("\nTable data:");
            while (table.next()){
                for(int i = 1; i<= columnCount; i++) {
                    System.out.format("%21s", table.getString(i) + "|");
                }
                System.out.println();
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
        try {
            Statement statement = connection.createStatement();
            ResultSet table = statement.executeQuery("select * from " + tableName);

            ResultSetMetaData metaData = table.getMetaData();
            int columnCount = metaData.getColumnCount();

            System.out.println("Table name: " + metaData.getTableName(1));
            System.out.format("%21s", "Field" + "|");
            for (int i = 1; i<= columnCount; i++){
                System.out.format("%21s", metaData.getColumnName(i) + "|");
            }
            System.out.println();
            System.out.format("%21s", "Type" + "|");
            for (int i = 1; i<= columnCount; i++) {
                System.out.format("%21s", metaData.getColumnTypeName(i) + "|");
            }
            System.out.println();
            System.out.format("%21s", "Precision" + "|");
            for (int i = 1; i<= columnCount; i++) {
                System.out.format("%21s", metaData.getPrecision(i) + "|");
            }
            System.out.println();
            table.close();
            statement.close();
        }catch(SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        }
    }
    public void printTables()
    {
        try {
            Statement statement = connection.createStatement();
            ResultSet tables = statement.executeQuery("SHOW TABLES");

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

    public String getTableColumnType(final String tableName, final int column){
        String result = "";
        try {
            Statement statement = connection.createStatement();
            ResultSet table = statement.executeQuery("select * from " + tableName);

            ResultSetMetaData metaData = table.getMetaData();
            result = metaData.getColumnTypeName(column);

            table.close();
            statement.close();
        }catch(SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        }
        return result;
    }

    public void updateInt(final String tableName, final int rowIndex, final int columnIndex, int newValue)
    {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM " + tableName,
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet tables = preparedStatement.executeQuery();

            tables.absolute(rowIndex);
            tables.updateInt(columnIndex, newValue);
            tables.updateRow();

            tables.close();
            preparedStatement.close();
        }catch(SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void updateString(final String tableName, final int rowIndex, final int columnIndex, final String newValue)
    {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM " + tableName,
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet tables = preparedStatement.executeQuery();

            tables.absolute(rowIndex);
            tables.updateString(columnIndex, newValue);
            tables.updateRow();

            tables.close();
            preparedStatement.close();
        }catch(SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        }
    }
    public void updateTimestamp(final String tableName, final int rowIndex, final int columnIndex, final long newValue)
    {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM " + tableName,
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet tables = preparedStatement.executeQuery();

            tables.absolute(rowIndex);
            Timestamp timestamp = new Timestamp(newValue);
            System.out.println("oleg");
            tables.updateTimestamp(columnIndex, timestamp);
            tables.updateRow();

            tables.close();
            preparedStatement.close();
        }catch(SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        }
    }
    public void insertRow(final String tableName, final int previousRowIndex)
    {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM " + tableName,
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet tables = preparedStatement.executeQuery();

            tables.absolute(previousRowIndex);
            tables.moveToInsertRow();
            tables.insertRow();

            tables.close();
            preparedStatement.close();
        }catch(SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        }
    }

    public String getTableName(final int index){
        String result = "";
        try {
            Statement statement = connection.createStatement();
            ResultSet tables = statement.executeQuery("SHOW TABLES");

            int i = 1;
            while(tables.next()) {
                if(index == i) {
                    result = tables.getString(1);
                    break;
                }
                i++;
            }

            tables.close();
            statement.close();
        }catch(SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        }
        return result;
    }

    public void deleteRow(final String tableName, final int rowIndex)
    {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM " + tableName,
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet tables = preparedStatement.executeQuery();

            tables.absolute(rowIndex);
            tables.deleteRow();

            tables.close();
            preparedStatement.close();
        }catch(SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        }
    }
}