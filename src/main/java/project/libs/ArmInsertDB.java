package project.libs;

import project.db.LibearchDB;
import java.sql.*;

public class ArmInsertDB {
    public static void insertUser(String username, String password, int banned) {
        Connection connection = LibearchDB.getConnection();
        try {
            String sql = "INSERT INTO users (username, password) VALUES ('" + username + "', '" + password + "')";
            Statement statement = connection.createStatement();
            statement.execute(sql);
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
    public static void insertBook(String bookName, String writerName, String publisher) {
        Connection connection = LibearchDB.getConnection();
        try {
            String sql = "INSERT INTO books (bookName, writerName, publisher) VALUES ('" + bookName + "', '" + writerName + "', '" + publisher + "')";
            Statement statement = connection.createStatement();
            statement.execute(sql);
            System.out.println(String.format("Insert book: %s\nWriter name: %s\nPublisher: %s", bookName, writerName, publisher));
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
