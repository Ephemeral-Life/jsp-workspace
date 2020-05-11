package com.Ephemeral.bean.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.commons.dbutils.ResultSetHandler;

public class Basedao
{
	public static Object query(String sql, ResultSetHandler<?> rsh, Object...params)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try 
		{
			conn=DBUtils.getConnection();
			pstmt=conn.prepareStatement(sql);
			for(int i=0;i<params.length&&params!=null;i++)
			{
				pstmt.setObject(i+1,params[i]);
			}
			rs=pstmt.executeQuery();
			Object obj=rsh.handle(rs);
			return obj;
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			DBUtils.close(conn, pstmt);
			DBUtils.close(rs, pstmt);
		}	
		return rs;
	}
}