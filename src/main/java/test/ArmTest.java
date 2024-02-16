package test;

import db.LibearchDB;

import java.sql.*;
import  java.util.*;

public class ArmTest {

    public static void insertDB(String email, String password) {
        Connection connection = LibearchDB.getConnection();
        try {
            String sql = "INSERT INTO users (email, password) VALUES ('" + email + "', '" + password + "')";
            Statement statement = connection.createStatement();
            statement.execute(sql);
            queryDB();
        } catch (SQLException e) {
            System.err.println("SQL error:" + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("SQL closing error:" + e.getMessage());
                }
            }
        }
    }

    public static void queryDB() {
        Connection connection = LibearchDB.getConnection();
        try {
            String sql = "SELECT * FROM users";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                String email = result.getString("email");
                String password = result.getString("password");
                System.out.println("Email: " + email + " Password: " + password);
            }

        } catch (SQLException e) {
            System.err.println("SQL error:" + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("SQL closing error:" + e.getMessage());
                }
            }
        }
    }

    public static void updateDB(String email, String new_password) {
        Connection connection = LibearchDB.getConnection();
        try {
            String sql = "UPDATE users SET password = '"+ new_password + "' WHERE email = '" + email + "';";
            Statement statement = connection.createStatement();
            statement.execute(sql);
            queryDB();
        } catch (SQLException e) {
            System.err.println("SQL error:" + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("SQL closing error:" + e.getMessage());
                }
            }
        }
    }

    public static void deleteDB(String email) {
        Connection connection = LibearchDB.getConnection();
        try {
            String sql = "DELETE FROM users WHERE email = '" + email + "'";
            Statement statement = connection.createStatement();
            statement.execute(sql);
            queryDB();
        } catch (SQLException e) {
            System.err.println("SQL error:" + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("SQL closing error:" + e.getMessage());
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Method (insert/update/query/delete): ");
        String method = sc.nextLine();
        switch (method) {
            case "insert" -> {
                System.out.print("Email: ");
                String email = sc.nextLine();
                System.out.print("Password: ");
                String password = sc.nextLine();
                insertDB(email, password);
            }
            case "query" -> queryDB();
            case "update" -> {
                System.out.print("Email: ");
                String email = sc.nextLine();
                System.out.print("New password: ");
                String new_password = sc.nextLine();
                updateDB(email, new_password);
            }
            case "delete" -> {
                System.out.print("Email: ");
                String email = sc.nextLine();
                deleteDB(email);
            }
            default -> System.out.println("Invalid method!!");
        }

    }
}
