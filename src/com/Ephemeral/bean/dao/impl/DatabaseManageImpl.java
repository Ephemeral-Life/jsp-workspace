package com.Ephemeral.bean.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.Ephemeral.bean.dao.Basedao;
import com.Ephemeral.bean.dao.DBUtils;
import com.Ephemeral.bean.dao.DatabaseManage;
import com.Ephemeral.bean.dao.FindLastId;
import com.Ephemeral.entity.Stuc;
import com.Ephemeral.entity.User;

public class DatabaseManageImpl extends Basedao implements DatabaseManage
{
	private Connection con;
	private Statement st;
	DBUtils dbu = new DBUtils();
	FindLastId lastId = new FindLastId();
	public User getUser(String name, String pw) throws SQLException
	{
		String sql="";
		sql="select * from login";
		ArrayList <User>list=(ArrayList<User>)super.query(sql, new BeanListHandler(User.class));
		for(User user:list)
		{
			if(user.getUsername().equals(name) && user.getPassword().equals(pw))
            {
            	return user;
            }
		}
		return null;
	}
	
	public ArrayList getAllUser() throws SQLException
	{
		String sql="";
		sql="select * from login";
		ArrayList <User>list=(ArrayList<User>)super.query(sql, new BeanListHandler(User.class));
		return list;
	}

	public void newUser(User user) throws SQLException, ClassNotFoundException
	{
		con = dbu.getConnection();
		String sql="";
		sql="insert login value("+(lastId.Id("id", "login")+1)+",'"+user.getUsername()+"','"+user.getPassword()+"',"+user.getType()+")";
		st=con.createStatement();
		st.executeUpdate(sql);
	}

	public void delStuc(int id) throws SQLException, ClassNotFoundException
	{
		con = dbu.getConnection();
		String sql="";
		sql="delete from stuc where id = " + id;
		st=con.createStatement();
		st.executeUpdate(sql);
	}

	public ArrayList getAllStuc() throws SQLException
	{
		String sql="";
		sql="select * from stuc";
		ArrayList <Stuc>list=(ArrayList<Stuc>)super.query(sql, new BeanListHandler(Stuc.class));
		return list;
	}
	
	public Stuc getstucById(int id) throws SQLException
	{
		Stuc stuc = new Stuc();
		String sql="";
		sql="select * from stuc where ID = " + id;
		ArrayList <Stuc>list=(ArrayList<Stuc>)super.query(sql, new BeanListHandler(Stuc.class));
		stuc = list.get(0);
		return stuc;
	}

	public void change(int id, Stuc stuc) throws SQLException, ClassNotFoundException
	{
		con = dbu.getConnection();
		String sql="";
		sql="update stuc set ID = " + stuc.getID() + ", cNo = '" + stuc.getcNo() +
				"', cName = '" + stuc.getcName() + "', cTeac = '" + stuc.getcTeac() +
				"', cDep = '" + stuc.getcDep() + "', isOnline = '" + stuc.getIsOnline()+ 
				"', cPf = '" + stuc.getcPf() + "', cMethod = '" + stuc.getcMethod() + "' where id = " + id;
		st=con.createStatement();
		st.executeUpdate(sql);
	}

	public ArrayList getCNameLike(String key) throws SQLException
	{
		String sql="";
		sql="select * from stuc where cName like '%" + key + "%'";
		ArrayList <Stuc>list=(ArrayList<Stuc>)super.query(sql, new BeanListHandler(Stuc.class));
		return list;
	}

	public void newStuc(Stuc stuc) throws SQLException, ClassNotFoundException
	{
		con = dbu.getConnection();
		String sql="";
		sql="insert stuc value("+(lastId.Id("id", "stuc")+1)+",'"
								+stuc.getcNo()+"','"
								+stuc.getcName()+"','"
								+stuc.getcTeac()+"','"
								+stuc.getcDep()+"','"
								+stuc.getIsOnline()+"','"
								+stuc.getcPf()+"','"
								+stuc.getcMethod()
								+"')";
		st=con.createStatement();
		st.executeUpdate(sql);
	}
}