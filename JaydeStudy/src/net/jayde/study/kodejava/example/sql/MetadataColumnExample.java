package net.jayde.study.kodejava.example.sql;

import java.sql.*;
import java.util.ArrayList;

public class MetadataColumnExample {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost/testdb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) throws Exception {
        Connection connection = null;
        try {
            //
            // As the usual ritual, load the driver class and get connection
            // from database.
            //
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            //
            // In the statement below we'll select all records from users table
            // and then try to find all the columns it has.
            //
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

            //
            // The ResultSetMetaData is where all metadata related information
            // for a result set is stored.
            //
            ResultSetMetaData metadata = resultSet.getMetaData();
            int columnCount = metadata.getColumnCount();

            //
            // To get the column names we do a loop for a number of column count
            // returned above. And please remember a JDBC operation is 1-indexed
            // so every index begin from 1 not 0 as in array.
            //
            ArrayList<String> columns = new ArrayList<String>();
            for (int i = 1; i < columnCount; i++) {
                String columnName = metadata.getColumnName(i);
                columns.add(columnName);
            }

            //
            // Later we use the collected column names to get the value of the
            // column it self.
            //
            while (resultSet.next()) {
                for (String columnName : columns) {
                    String value = resultSet.getString(columnName);
                    System.out.println(columnName + " = " + value);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }
}
