package net.jayde.app.music.util;


import java.sql.Connection;
import java.sql.DriverManager;

public class MusicDb {
    String sourceURL =
            "jdbc:h2:c:\\Users\\Administrator\\IdeaProjects\\JaydeCS\\db\\Db_h2_mybatis.mv.db";
    //  String sourceURL = "jdbc:h2:d:\\IdeaProjects\\JaydeCS\\db\\Db_h2_mybatis.mv.db";
    Connection conn = null;

    public void connDb() {
        try {
            String user = "";
            String key = "";
            Class.forName("org.h2.Driver");// HSQLDB Driver

            conn = DriverManager.getConnection(sourceURL, "", "");

        } catch (Exception sqle) {
            System.out.println(sqle.getMessage());
        }
    }

    public void disconnDb() {
        try {
            conn.close();
        } catch (Exception sqle) {
            System.out.println(sqle.getMessage());
        }
    }
}
