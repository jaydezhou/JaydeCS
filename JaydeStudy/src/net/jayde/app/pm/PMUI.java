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

        conn=DriverManager.getConnection(sourceURL,user,key);//��������������
       // Statement stmt=conn.createStatement();
                //����һ�� Statement �������� SQL ��䷢�͵����ݿ⡣
        //stmt.executeUpdate("DELETE FROM mytable WHERE name=/'NO.2/'");
                //ִ�з����ҵ�һ���� methodName ����ͬ���ķ���������Ŀ���ϵ��ø÷�����
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

