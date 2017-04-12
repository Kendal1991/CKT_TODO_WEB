package com.ckt.ckttodo.sqldata;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetSqlData {
	public String getdata(String name) {
		String pwd = "null";
		Connection conn = Sqldata.SQLConn();
		try {
			if (!conn.isClosed()) {
				System.out.println("数据库连接成功");
				Statement state = conn.createStatement();
				String sql = "select * from member where mem_name=" + "'" + name
						+ "'";
				ResultSet rs = state.executeQuery(sql);
				if (rs.next()) {
					pwd = rs.getString("mem_pwd");
				} else {
					System.out.println("用户名不存在");
				}
				rs.close();
			} else {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pwd;
	}
	public String insertData(String name,String password,String email,int level,String token,long token_create_time) {
		String result = "null";
		Connection conn = Sqldata.SQLConn();
		try {
			if (!conn.isClosed()) {
				System.out.println("数据库连接成功");
				String sql1 = "select * from member where mem_name=" + "'" + name
						+ "'";
				Statement state = conn.createStatement();
				ResultSet rs1 = state.executeQuery(sql1);
				if(rs1.next()){
					result="0";
					return result;
				}
				String sql = "insert into member (mem_id,mem_name,mem_pwd,mem_email,mem_level,token,token_create_time) values("+"NULL,'"+name+"','"+password+"','"+email+"','"+level+"','"+token+"','"+token_create_time+"')";
				int rs = state.executeUpdate(sql);
				if (rs==0) {
					result = "0";
				} else {
					result = "1";
				}
			} else {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
