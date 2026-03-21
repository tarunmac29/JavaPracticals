/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.practical3;

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author hp
 */
public class Practical3 {

    public static void main(String[] args) throws ClassNotFoundException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter user name");
        String name = sc.next();
        System.out.println("Enter password");
        String pass = sc.next();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "");
            String loginQuery = "INSERT INTO login values(?,?)";
            PreparedStatement ps = con.prepareStatement(loginQuery);
            ps.setString(1, name);
            ps.setString(2, pass);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("User registered successfully!");
            }

            System.out.println("\n -------Enter login info-------\n");
            System.out.println("Enter user name");
            String un = sc.next();
            System.out.println("Enter password");
            String pw = sc.next();
            String query = "SELECT * FROM login WHERE username= ? AND password= ?";

            ps = con.prepareStatement(query);

            ps.setString(1, un);
            ps.setString(2, pw);
            ResultSet rs = ps.executeQuery();
            rs.next();
            if (rs.getRow() > 0) {
                System.out.println("Login successful " + rs.getString("username"));
            } else {
                System.out.println("Login failed -- Invalid credentials or user not found");
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Database connectivity failed" + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
