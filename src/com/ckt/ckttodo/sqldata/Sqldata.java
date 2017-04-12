package com.ckt.ckttodo.sqldata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Sqldata {
	public static Connection conn=null;
    public static Connection SQLConn(){
	     String driver="com.mysql.jdbc.Driver";
	     String url = "jdbc:mysql://localhost:3306/ckt_todo?useUnicode=true&characterEncoding=utf-8";
	     String user="root";
	     String password="root";
	     if(conn!=null){
	    	 return conn;
	     }
	     try {
	    	 Class.forName(driver);
	    	 conn=DriverManager.getConnection(url,user,password);
	     } 
	     catch (ClassNotFoundException e) {
	     e.printStackTrace();
	     } catch (SQLException e) {
		 e.printStackTrace();
	     }
	     return conn; 
    } 
    
}
