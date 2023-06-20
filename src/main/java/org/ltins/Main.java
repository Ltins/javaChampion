package org.ltins;

import java.util.Scanner;
import java.sql.*;

import DataBase.DBConnection;

public class Main {
    public static void main(String[] args) {
//            Scanner in = new Scanner(System.in);
//            System.out.print("Input your password: ");
//            String password = in.nextLine();
//            in.close();

            //DBConnection oleg = new DBConnection(password);
            DBConnection oleg = new DBConnection("root","18422184", "oleg");

            oleg.printTables();
            oleg.printTable("employees");
            oleg.printTableInfo("employees");
    }
}