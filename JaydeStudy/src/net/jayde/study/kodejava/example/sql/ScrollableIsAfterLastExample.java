package net.jayde.study.kodejava.example.sql;

import java.sql.*;

public class ScrollableIsAfterLastExample {
    public static void main(String[] args) throws Exception {
        Connection connection = null;
        try {
            String url = "jdbc:mysql://localhost/testdb";

            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, "root", "");

            Statement statement = connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet =
                    statement.executeQuery("SELECT * FROM products");

            //
            // Using the isBeforeFirst() method we can check if we are 
            // at the beginning of the result set.
            //
            if (resultSet.isAfterLast()) {
                System.out.println("You are at the beginning of the " +
                        "result set.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
}
