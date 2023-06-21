package org.ltins;

import java.util.Scanner;
import java.sql.*;

import UserInterface.SimpleMenu;

public class Main {
    public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            System.out.print("Input your password: ");
            String password = in.nextLine();

            SimpleMenu menu = new SimpleMenu("root", password, "oleg", in);
            menu.mainLoop();
            in.close();
    }
}