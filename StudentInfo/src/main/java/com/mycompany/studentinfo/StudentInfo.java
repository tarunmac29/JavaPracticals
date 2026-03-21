/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.studentinfo;

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author hp
 */
public class StudentInfo {

    public static void insertUser(Connection con, Scanner sc) {
        try {
            System.out.println("Enter user id");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter user name");
            String name = sc.nextLine();
            System.out.println("Enter user age");
            int age = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter user course");
            String course = sc.nextLine();

            String query = "INSERT INTO student values(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, age);
            ps.setString(4, course);

            int row = ps.executeUpdate();
            if (row > 0) {
                System.out.println("User registered successfully!");
            } else {
                System.out.println("Failed to insert!");

            }

        } catch (SQLException e) {
            System.out.println("Failed to insert " + e.getMessage());
        }
    }

    public static void updateUser(Connection con, Scanner sc) {

        try {
            System.out.println("Enter user id");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter user name for update : ");
            String name = sc.nextLine();
            System.out.println("Enter user age for update : ");
            int age = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter user course for update : ");
            String course = sc.nextLine();

            String query = "Update student set name= ?, age= ? , course= ? where id= ? ";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, course);
            ps.setInt(4, id);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println(" Update successful! Rows affected: " + rowsAffected);
            } else {
                System.out.println("️ No student found with ID: " + id);
            }
        } catch (SQLException e) {
            System.out.println("Failed to update " + e.getMessage());
        }
    }

    public static void deleteUser(Connection con, Scanner sc) {

        try {
            System.out.println("Enter user id");
            int id = sc.nextInt();
            sc.nextLine();

            String query = "DELETE FROM student WHERE id = ?";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println(" User deleted successful! Rows affected: " + rowsAffected);
            } else {
                System.out.println("️ No student found with ID: " + id);
            }

        } catch (SQLException e) {
            System.out.println("Failed to update " + e.getMessage());
        }

    }

    public static void getUsers(Connection con, Scanner sc) {

        try {

            String query = "SELECT * FROM student";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id")
                        + " Name: " + rs.getString("name")
                        + " Age: " + rs.getInt("age")
                        + " Course: " + rs.getString("course"));
            }
        } catch (SQLException e) {
            System.out.println("Failed to update " + e.getMessage());
        }

    }

    public static void main(String[] args) throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "");

            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.println("\nEnter choise \n");
                System.out.println("\n1. Insert User");
                System.out.println("\n2. Update User");
                System.out.println("\n3. Delete User");
                System.out.println("\n4. Get User");
                System.out.println("\n5. Exit");
                int ch = sc.nextInt();
                if (ch == 5) {
                    break;
                }
                switch (ch) {
                    case 1:
                        insertUser(con, sc);
                        break;
                    case 2:
                        updateUser(con, sc);
                        break;
                    case 3:
                        deleteUser(con, sc);
                        break;
                    case 4:
                        getUsers(con, sc);
                        break;

                }

            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Database connectivity failed" + e.getMessage());
        }

    }
}
