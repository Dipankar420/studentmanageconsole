package com.student.manage;

import java.sql.Connection;
import java.sql.DriverManager;

public class Cp {
    public static Connection createC() {
        Connection con = null;
        try {
            // load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // create the connetion...
            String user = "root";
            String password = "password";
            String url = "jdbc:mysql://localhost:3306/Student_manage";
            con = DriverManager.getConnection(url, user, password);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}
