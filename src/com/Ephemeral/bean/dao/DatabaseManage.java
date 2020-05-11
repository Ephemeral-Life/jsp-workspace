package com.Ephemeral.bean.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Ephemeral.entity.Stuc;
import com.Ephemeral.entity.User;

public interface DatabaseManage
{
	User getUser(String name, String pw) throws SQLException;
	ArrayList getAllUser() throws SQLException;
	ArrayList getAllStuc() throws SQLException;
	ArrayList getCNameLike(String key) throws SQLException;
	Stuc getstucById(int id) throws SQLException;
	void change(int id, Stuc stuc) throws SQLException, ClassNotFoundException;
	void delStuc(int id) throws SQLException, ClassNotFoundException;
	void newUser(User user) throws SQLException, ClassNotFoundException;
	void newStuc(Stuc stuc) throws SQLException, ClassNotFoundException;
}
