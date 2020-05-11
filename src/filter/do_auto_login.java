package filter;

//以下代码由小黄鸭调试法，
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Ephemeral.bean.dao.impl.DatabaseManageImpl;
import com.Ephemeral.entity.User;

/**
 * Servlet Filter implementation class do_auto_login
 */
@WebFilter("/do_auto_login")
public class do_auto_login implements Filter
{

	/**
	 * Default constructor.
	 */
	public do_auto_login()
	{
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @see Filter#destroy()
	 */
	public void destroy()
	{
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException
	{
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		response.setContentType("text/html;charset=gbk");
		String docType = "<!DOCTYPE html> \n";
		HttpSession session = req.getSession();
		PrintWriter out = response.getWriter();
		DatabaseManageImpl manage = new DatabaseManageImpl();
		int auto_login_flag = 1;
		try 
		{
			auto_login_flag = Integer.valueOf(session.getAttribute("auto_login_filter").toString());
		}
		catch(NullPointerException e)
		{
			;
		}
		Cookie[] cookies = null;
		cookies = req.getCookies();
		User user = new User();
		user = null;
		String userName = null;
		String pwd = null;
		if(auto_login_flag == 0)
			chain.doFilter(request, response);
		else
		{
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
						chain.doFilter(request, response);
					}
					else
					{
						out.println
						(
							docType + "<html>\n" + "<head><title>账号不存在</title></head>\n" 
							+ "<body>"
							+ "<script>alert('账号不存在。'); window.location='index.jsp' </script>"
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
					docType + "<html>\n" + "<head><title>cookie不存在或已经过期</title></head>\n" 
					+ "<body>"
					+ "<script>alert('cookie不存在或已经过期，不能使用自动登录。'); window.location='index.jsp' </script>"
					+ "</body>"
					+ "</html>"
				);
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException
	{
		// TODO Auto-generated method stub
	}
}
