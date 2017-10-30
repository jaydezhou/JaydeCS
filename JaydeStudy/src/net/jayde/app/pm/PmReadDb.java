package net.jayde.app.pm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PmReadDb {

//    String sourceURL = "jdbc:h2:c:\\Users\\Administrator\\IdeaProjects\\JaydeCS\\db\\Db_h2_mybatis.mv.db";
    String sourceURL = "jdbc:h2:d:\\IdeaProjects\\JaydeCS\\db\\Db_h2_mybatis.mv.db";
    Connection conn = null;
    ProjectLibrary library= new ProjectLibrary();

    public void connDb() {
        try {
            String user = "";
            String key = "";
            Class.forName("org.h2.Driver");//HSQLDB Driver

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
            ResultSet rsGroup = stmt.executeQuery("select * from p2group order by sortorder");
            while (rsGroup.next()) {
                String gid = rsGroup.getString("id");
                String gname = rsGroup.getString("gname");
                ProjectGroup group = new ProjectGroup();
                group.setName(gname);
                System.out.println(gid + ":" + gname);
                cycleProject(group,gid);
                library.getGroups().add(group);
            }
            rsGroup.close();
            stmt.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public void cycleProject(ProjectGroup group ,String gid) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rsProject = stmt.executeQuery("select * from p2Project where gid='" + gid + "' order by id");
            while (rsProject.next()) {
                String pid = rsProject.getString("id");
                String pname = rsProject.getString("pname");
                ProjectObject project = new ProjectObject();
                project.setPname(pname);
                group.getProjects().add(project);
                System.out.println("    " + pid + ":" + pname);
            }
            rsProject.close();
            stmt.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ProjectLibrary readByDb(){
        connDb();
        cycleGroup();
        disconnDb();
        return library;
    }

    public static void main(String[] args) {
        PmReadDb pmReadDb = new PmReadDb();
        System.out.println(pmReadDb.readByDb().toString());
    }
}
