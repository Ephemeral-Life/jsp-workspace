package servlet;

import java.awt.Color;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Ephemeral.bean.dao.impl.DatabaseManageImpl;
import com.Ephemeral.entity.User;

@WebServlet("/do_login")
public class do_account_login extends HttpServlet
{

	/**
	 * Constructor of the object.
	 */
	public do_account_login()
	{
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy()
	{
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request  the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException      if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html;charset=gbk");
		String docType = "<!DOCTYPE html> \n";
		PrintWriter out = response.getWriter();
		out.println
		(
			docType + "<html>\n" + "<head><title>不要打破第四面墙</title></head>\n" 
			+ "<body>"
			+ "<script>alert('为防止暴力破解，get提交被禁止。'); window.location='../index.jsp' </script>"
			+ "</body>"
			+ "</html>"
		);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request  the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException      if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		DatabaseManageImpl manage = new DatabaseManageImpl();
		HttpSession session = request.getSession();
		String docType = "<!DOCTYPE html> \n";
		PrintWriter out = response.getWriter();
		User user = new User();
		user = null;
		String name = request.getParameter("username");
		String pwd = request.getParameter("password");
		String verifyInput = request.getParameter("checkcode");
		String verifyCode = (String) session.getAttribute("verificationCode");
		Cookie[] cookies = null;
		cookies = request.getCookies();
		String nameCookie = "";
		String pwdCookie = "";
		if(cookies.length > 1)
		{
			for (int i = 0; i < cookies.length; i++) 
			{
				String nameSave = cookies[i].getName();
				String valueSave = cookies[i].getValue();
				if(nameSave.equals("userNameCookie"))
				{
					nameCookie = valueSave;
				}
				if(nameSave.equals("passWordCookie"))
				{
					pwdCookie = valueSave;
				}
			}
		}
		else
		{
			
		}
		if(verifyInput.equalsIgnoreCase(verifyCode))
		{
			try
			{
				user = manage.getUser(name, pwd);
				if(user != null)
				{
					session.setAttribute("auto_login_filter", 0);
					session.setAttribute("userName", user.getUsername());
					session.setAttribute("passWord", user.getPassword());
					session.setAttribute("type", user.getType());
				}
				else
				{
					session.setAttribute("auto_login_filter", 0);
					session.setAttribute("userName", null);
					session.setAttribute("passWord", null);
					session.setAttribute("type", null);
				}
				if(nameCookie.equals(name) && pwdCookie.equals(pwd))
					response.sendRedirect("/loginServlet/servlet/do_redirecter");
				else
				{
					out.println
					(
						docType + "<html>\n" + "<head><title>保持你的登录状态--by：王泽洋</title></head>\n" 
						+ "<body>"
						+ "<script>window.location='../../loginServlet/action/ask_cookie_save.jsp' </script>"
						+ "</body>"
						+ "</html>"
					);
				}
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			out.println
			(
				docType + "<html>\n" + "<head><title>验证码错误</title></head>\n" 
				+ "<body>"
				+ "<script>alert('验证码输入错误。'); window.location='../index.jsp' </script>"
				+ "</body>"
				+ "</html>"
			);
		}
	}
	
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException
	{
		// Put your code here
	}

}
