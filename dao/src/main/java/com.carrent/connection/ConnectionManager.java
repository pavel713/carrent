package com.carrent.connection;

import java.sql.*;

public class ConnectionManager {
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/prokat?autoReconnect=true&useSSL=false&characterEncoding=UTF-8&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASS = "root";


    
    static {
        try {
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASS);
            System.out.print("Connection OK");

        } catch (Exception ex) {
            System.out.println("Error (DbConnection): " + ex);
        }
        return connection;
    }
}

