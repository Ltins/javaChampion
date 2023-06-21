package UserInterface;

import DataBase.DBConnection;

import java.util.Scanner;
import java.sql.Timestamp;

public class SimpleMenu {
    private String currentTable;
    private DBConnection connection;
    private Scanner in;
    public SimpleMenu(final String username, final String password, final String urlindex, Scanner inputStream){
       connection = new DBConnection(username, password, urlindex);
       currentTable = "";
       in = inputStream;
    }

    private void alterTable(final int column, final int row){
        switch(connection.getTableColumnType(currentTable, column))
        {
            case "INT":
            {
                System.out.println("Input new integer");
                int newValue = in.nextInt();
                connection.updateInt(currentTable, row, column, newValue);
                break;
            }
            case "VARCHAR":
            {
                System.out.println("Input new value string");
                in.nextLine();
                String newValue = in.nextLine();
                connection.updateString(currentTable, row, column, newValue);
                break;
            }
            case "TIMESTAMP":
            {
                System.out.println("Input time in milliseconds :))");
                long newValue = in.nextLong();
                connection.updateTimestamp(currentTable, row, column, newValue);
                break;
            }
        }
    }
    public void mainLoop()
    {
        while(true) {
            if (currentTable == "") {
                System.out.println("Choose table to work with:");
                connection.printTables();
                System.out.println("[0] - Nah, I hate databases!");
                int index = in.nextInt();
                if (index == 0) {
                    return;
                } else {
                    currentTable = connection.getTableName(index);
                }
            } else {
                connection.printTableInfo(currentTable);
                System.out.println();
                connection.printTable(currentTable);
                System.out.println("Choose action: ");
                System.out.println("1) Insert new row");
                System.out.println("2) Alter table row");
                System.out.println("3) Delete table row");
                System.out.println("0) Return to previous menu");
                int index = in.nextInt();
                switch(index)
                {
                    case 0:
                    {
                        currentTable = "";
                        break;
                    }
                    case 1:
                    {
                        System.out.println("Input future row index in result table:");
                        int rowIndex = in.nextInt();
                        connection.insertRow(currentTable, rowIndex - 1);
                        break;
                    }
                    case 2:
                    {
                        System.out.println("Choose row and column index");
                        System.out.println("Column: ");
                        int columnIndex = in.nextInt();
                        System.out.println("Row: ");
                        int rowIndex = in.nextInt();
                        alterTable(columnIndex, rowIndex);
                        break;
                    }
                    case 3:
                    {
                        System.out.println("Input row index:");
                        int rowIndex = in.nextInt();
                        connection.deleteRow(currentTable, rowIndex);
                        break;
                    }
                }
            }
        }
    }

}
