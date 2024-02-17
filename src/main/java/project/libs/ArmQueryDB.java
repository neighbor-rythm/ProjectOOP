package project.libs;

import project.db.LibearchDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ArmQueryDB {
    public static String findUser(String username, String password) {

        String user = null;
        String pass = null;
        int isBanned = 0;

        Connection connection = LibearchDB.getConnection();
        try {
            String sql = "SELECT username, password, banned FROM users where username = '" + username + "'";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            if (result.next()) {
                user = result.getString("username");
                pass = result.getString("password");
                isBanned = result.getInt("banned");
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
        // System.out.println("Query result: " + "User: " + user + " Pass: " + pass + " isBanned: " + isBanned);
        if (user != null && pass != null && isBanned == 0) {
            if (password.equals(pass)) {
                return "Verify";
            } else {
                return "Username or Password is incorrect.";
            }
        } else if (user == null) {
            return "Cannot find this user.";
        } else {
            return "Not verify.";
        }
    }
}
