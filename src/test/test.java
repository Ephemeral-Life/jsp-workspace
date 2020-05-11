package test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Ephemeral.bean.dao.FindLastId;
import com.Ephemeral.bean.dao.impl.DatabaseManageImpl;
import com.Ephemeral.entity.Stuc;
import com.Ephemeral.entity.User;

public class test
{
	public static void main(String[] args) throws SQLException, ClassNotFoundException
	{
		ResultSet rs = null;
		DatabaseManageImpl manage = new DatabaseManageImpl();
		User user = new User();
		Stuc stuc = new Stuc();
		user.setUsername("test");
		user.setPassword("test");
		user.setType(2);
		manage.newUser(user);
	}
}
