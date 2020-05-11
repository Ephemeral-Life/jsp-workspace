package com.Ephemeral.bean.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils
{
	public static Connection getConnection() throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/course?characterEncoding=UTF-8";
		String name = "root";
		String pwd = "root";
		Connection conn = DriverManager.getConnection(url, name, pwd);
		return conn;
	}

	public static void close(Connection conn, Statement stmt)
	{
		if (stmt != null)
		{
			try
			{
				stmt.close();
			} catch (Exception e)
			{
				e.printStackTrace();
			}
			stmt = null;
		}
		if (conn != null)
		{
			try
			{
				conn.close();
			} catch (Exception e)
			{
				e.printStackTrace();
			}
			conn = null;
		}
	}

	public static void close(ResultSet rs, Statement stmt)
	{
		if (stmt != null)
		{
			try
			{
				stmt.close();
			} catch (Exception e)
			{
				e.printStackTrace();
			}
			stmt = null;
		}
		if (rs != null)
		{
			try
			{
				rs.close();
			} catch (Exception e)
			{
				e.printStackTrace();
			}
			rs = null;
		}
	}
}
