package app;
import  db.LibearchDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        // for any code write in app eiei
        Book book1 = new Book();
        book1.setNameBook("ThinkPython");
        book1.setNameWriter("Chotipat");
        insertDB(book1.getNameBook(), book1.getNameWriter());

    }
    public static void insertDB(String nameBook, String nameWriter) {
        Connection connection = LibearchDB.getConnection();
        try {
            String sql = "INSERT INTO users (email, password) VALUES ('" + nameBook + "', '" + nameWriter + "')";
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
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
