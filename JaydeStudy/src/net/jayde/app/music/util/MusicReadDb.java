package net.jayde.app.music.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import net.jayde.app.music.pojo.MusicGroup;
import net.jayde.app.music.pojo.MusicLibrary;
import net.jayde.app.music.pojo.MusicPerson;

public class MusicReadDb {

  // String sourceURL =
  // "jdbc:h2:c:\\Users\\Administrator\\IdeaProjects\\JaydeCS\\db\\Db_h2_mybatis.mv.db";
  String sourceURL = "jdbc:h2:d:\\IdeaProjects\\JaydeCS\\db\\Db_h2_mybatis.mv.db";
  Connection conn = null;
  MusicLibrary library = new MusicLibrary();
  private static Logger logger = LogManager.getLogger(MusicReadDb.class.getName());

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



    public void cycleGroup() {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rsGroup = stmt.executeQuery("select * from musicgroup order by id");
            while (rsGroup.next()) {
                String gid = rsGroup.getString("id");
                String gname = rsGroup.getString("name");
                MusicGroup mg = new MusicGroup(gid,gname);
                System.out.println(mg);
                cyclePerson(mg,gid);
                library.getGroups().add(mg);
            }
            rsGroup.close();
            stmt.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public void cyclePerson(MusicGroup group, String gid) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rsPerson= stmt.executeQuery("select * from musicPerson where mgid='" + gid + "' order by id");
            while (rsPerson.next()) {

                String pid = rsPerson.getString("id");
                String pname = rsPerson.getString("name");
                MusicPerson person= new MusicPerson(pid,pname,gid,group);
//                cycleQuestions(project,pid);
                group.getPersonSet().add(person);
                System.out.println(person);
            }
            rsPerson.close();
            stmt.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public MusicLibrary readByDb() {
        connDb();
        cycleGroup();
        disconnDb();
        return library;
    }

    public static void main(String[] args) {
        MusicReadDb musicReadDb = new MusicReadDb();
        System.out.println(musicReadDb.readByDb().toString());
    }

}
