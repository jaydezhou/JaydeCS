package net.jayde.study.kodejava.example.io;

import java.io.FileOutputStream;
import java.util.Properties;

public class PropertiesToXml {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.setProperty("database.type", "mysql");
        properties.setProperty("database.url", "jdbc:mysql://localhost/mydb");
        properties.setProperty("database.username", "root");
        properties.setProperty("database.password", "root");

        FileOutputStream fos = new FileOutputStream("database-configuration.xml");
        properties.storeToXML(fos, "Database Configuration", "UTF-8");
    }
}
