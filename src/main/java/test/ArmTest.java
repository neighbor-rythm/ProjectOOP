package test;

import db.LibearchDB;

import java.sql.*;

public class ArmTest {

    public static void main(String[] args) {
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
}
