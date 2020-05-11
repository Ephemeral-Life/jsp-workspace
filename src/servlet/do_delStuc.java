package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Ephemeral.bean.dao.impl.DatabaseManageImpl;

/**
 * Servlet implementation class do_delAccount
 */
@WebServlet("/do_delAccount")
public class do_delStuc extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public do_delStuc()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		DatabaseManageImpl manage = new DatabaseManageImpl();
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String docType = "<!DOCTYPE html> \n";
		String userName= (String)session.getAttribute("userName");
		int id = Integer.valueOf(request.getParameter("id"));
		try
		{
			manage.delStuc(id);
		} catch (SQLException | ClassNotFoundException e)
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		out.println(
						docType + "<html>\n" + "<head><title>删除课程--by:王泽洋</title></head>\n" 
						+ "<body>"
						+ "<script>alert('完成了。');window.location='../main.jsp';</script>"
						+ "</body>"
						+ "</html>"
					);
	}
}
