//寻找msg表中最后一条记录的msgId值
package com.Ephemeral.bean.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.Ephemeral.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;

public class FindLastId extends Basedao
{
	private Connection con;
	private Statement st;
	public int Id(String listName, String table) throws SQLException
	{
		int lastId = 0;
		String sql="";
		sql="select " + listName + " from " + table + " order by " + listName + " DESC limit 1;";
		ArrayList <User>list=(ArrayList<User>)super.query(sql, new BeanListHandler(User.class));
		for(User user:list)
		{
			lastId = user.getId();
		}
		return lastId;
	}
}
