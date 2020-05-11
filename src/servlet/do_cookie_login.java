package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Ephemeral.bean.dao.impl.DatabaseManageImpl;
import com.Ephemeral.entity.User;

/**
 * Servlet implementation class do_cookie_login
 */
@WebServlet("/do_cookie_login")
public class do_cookie_login extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public do_cookie_login()
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
		String docType = "<!DOCTYPE html> \n";
		PrintWriter out = response.getWriter();
		Cookie[] cookies = request.getCookies();
		User user = new User();
		user = null;
		String userName = null;
		String pwd = null;
		if(cookies.length > 1)
		{
			for (int i = 0; i < cookies.length; i++) 
			{
				String name = cookies[i].getName();
				String value = cookies[i].getValue();
				if(name.equals("userNameCookie"))
				{
					userName = value;
				}
				if(name.equals("passWordCookie"))
				{
					pwd = value;
				}
			}
			try
			{
				user = manage.getUser(userName, pwd);
				if(user != null)
				{
					session.setAttribute("userName", user.getUsername());
					session.setAttribute("passWord", user.getPassword());
					session.setAttribute("type", user.getType());
				}
				else
				{
					session.setAttribute("userName", null);
					session.setAttribute("passWord", null);
					session.setAttribute("type", null);
				}
				response.sendRedirect("/loginServlet/servlet/do_redirecter");
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			out.println
			(
				docType + "<html>\n" + "<head><title>没找到登录cookie</title></head>\n" 
				+ "<body>"
				+ "<script>alert('没找到登录cookie，\\n你必须至少成功登录过一次才能使用cookie登录。'); window.location='../index.jsp' </script>"
				+ "</body>"
				+ "</html>"
			);
		}
	}
}
