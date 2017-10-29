package net.jayde.app.pm;

import java.sql.*;

public class PMUI {

	String sourceURL = "jdbc:h2:D:\\IdeaProjects\\JaydeCS\\db\\Db_h2_mybatis.mv.db";
    Connection conn = null;

    	public void connDb(){
		try{
                String user="";
                String key="";
       Class.forName("org.h2.Driver");//HSQLDB Driver

        conn=DriverManager.getConnection(sourceURL,user,key);//把驱动放入连接
       // Statement stmt=conn.createStatement();
                //创建一个 Statement 对象来将 SQL 语句发送到数据库。
        //stmt.executeUpdate("DELETE FROM mytable WHERE name=/'NO.2/'");
                //执行方法找到一个与 methodName 属性同名的方法，并在目标上调用该方法。
        //stmt.execute("CREATE TABLE idtable(id INT,name VARCHAR(100));");
        //stmt.close();

    }catch(Exception sqle){
                System.out.println(sqle.getMessage());
    }
	}

	public void cycleGroup(){
		try{
		Statement stmt = conn.createStatement();
		ResultSet rsGroup = stmt.executeQuery("select * from p2group order by sortorder");
		while(rsGroup.next()){
String gid = rsGroup.getString("id");
String gname = rsGroup.getString("gname");
System.out.println(gid+":"+gname);
cycleProject(gid);
		}
		rsGroup.close();
		stmt.close();
		}
		catch(Exception e){
                System.out.println(e.getMessage());
		}
	}


	public void cycleProject(String gid){
		try{
		Statement stmt = conn.createStatement();
		ResultSet rsProject = stmt.executeQuery("select * from p2Project where gid='"+gid+"' order by id");
		while(rsProject.next()){
String pid = rsProject.getString("id");
String pname = rsProject.getString("pname");
System.out.println("    "+pid+":"+pname);
		}
		rsProject.close();
		stmt.close();
		}
		catch(Exception e){
                System.out.println(e.getMessage());
		}
	}

public static void main(String[] args){
	PMUI pmui = new PMUI();
	pmui.connDb();
	pmui.cycleGroup();
	pmui.disconnDb();
}
	public void disconnDb(){
		try{
			conn.close();
		}catch(Exception sqle)
		{
                System.out.println(sqle.getMessage());
		}
	}
}

